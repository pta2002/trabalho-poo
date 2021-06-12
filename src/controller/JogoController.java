package controller;

import model.Equipa.Equipa;
import model.Exceptions.EquipaNaoExisteException;
import model.Exceptions.EquipasIguaisException;
import model.FootballManagerModel;
import model.Jogo.Evento.EventoJogo;
import model.Jogo.Jogo;
import model.Jogo.ModeloTatico;
import view.JogoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class JogoController extends  Menu{

    @Override
    public void executa(FootballManagerModel model) {
        JogoView view = new JogoView();
        Jogo jogo = new Jogo();
        handleEquipa(jogo,model,view,1);
        handleEquipa(jogo,model,view,2);
        modeloTaticoCasa(jogo, view);
        modeloTaticoVisitante(jogo, view);
        // perguntar se quer troca do jogador

        EventoJogo ultimo;

        while ((ultimo = jogo.avancaSimulacao(model)) != null && ultimo.getTempo() < 90 * 60) {
            System.out.println(ultimo.toString());
        }

        System.out.println("Final: " + jogo.getGolosCasa() + " - " + jogo.getGolosFora());
    }
    private void modeloTaticoVisitante(Jogo jogo, JogoView view) {
        escolheModeloTatico(jogo,view,4);
    }
    private void modeloTaticoCasa(Jogo jogo, JogoView view) {
        escolheModeloTatico(jogo,view,3);
    }
    private void escolheModeloTatico(Jogo jogo, JogoView view, int op) {
        view.mensagens(op);
        ArrayList<String> l = new ArrayList<>();
        for (ModeloTatico c : ModeloTatico.getModelos()) {
            l.add(c.toString());
        }
        int querMudarModelo = Menu.showMenuReadOption(new ArrayList<>(Arrays.asList("Sim", "Não")));
        if (querMudarModelo == 1) {
            int op2 = Menu.showMenuReadOption(l);
            Consumer<ModeloTatico> fun = op == 3 ? jogo::setModeloTaticoCasa : jogo::setModeloTaticoFora;

            // TODO: Melhorar isto, para suportar qualquer tipo de modelo
            switch (op2) {
                case 1:
                    fun.accept(new ModeloTatico(4,4,2));
                    break;
                case 2:
                    fun.accept(new ModeloTatico(4,3,3));
                    break;
                case 3:
                    fun.accept(new ModeloTatico(3,5,2));
                    break;
                default:
                    break;
            }
        }

    }
    private void handleEquipa(Jogo jogo, FootballManagerModel model, JogoView view, int opcao ) {
        try{
            Consumer<Equipa> fun = opcao == 1 ? jogo::setEquipaCasa : jogo::setEquipaFora;
                fun.accept(model.getEquipa(escolhaEquipa(model,view,opcao,jogo)));
        }
        catch (Exception e) {
            if (e instanceof EquipaNaoExisteException) view.erros(1);
            if (e instanceof EquipasIguaisException) view.erros(2);
            handleEquipa(jogo,model,view,opcao);
        }
    }
    private String escolhaEquipa(FootballManagerModel model, JogoView view, int opt, Jogo jogo) throws EquipaNaoExisteException, EquipasIguaisException {
        Scanner s = new Scanner(System.in);
        view.mensagens(opt);
        String equipa  = s.nextLine();
        if(!model.existeEquipa(equipa)) throw new EquipaNaoExisteException();
        if (opt == 2 && equipa.equals(jogo.getEquipaCasa())) throw new EquipasIguaisException();
        return equipa;
    }
}
