package controller;

import model.Exceptions.Equipa.EquipaNaoExisteException;
import model.Exceptions.Equipa.EquipasIguaisException;
import model.FootballManagerModel;
import model.Jogo.Jogo;
import view.JogoView;

import java.util.Scanner;

public class JogoController extends  Menu{

    @Override
    public void executa(FootballManagerModel model) {
        JogoView view = new JogoView();
        Jogo jogo = new Jogo();
        handleEquipa(jogo,model,view,1);
        handleEquipa(jogo,model,view,2);
        System.out.println(jogo.getEquipaCasa());
        System.out.println(jogo.getEquipaFora());


    }
    private void handleSetup(Jogo jogo, FootballManagerModel model, JogoView view, int opcao ) {
        //try {
        //
        //}
        //catch(k)

    }
    private void handleEquipa(Jogo jogo, FootballManagerModel model, JogoView view, int opcao ) {
        //var cenas = (opcao == 1) ? x -> jogo.setEquipaCasa(x) : x -> jogo.setEquipaFora(x);

        try{
            if(opcao == 1) {
                jogo.setEquipaCasa(escolhaEquipa(model,view,opcao,jogo));
            }
            else {
                jogo.setEquipaFora(escolhaEquipa(model,view,opcao,jogo));
            }
        }
        catch (Exception e) {
            if (e instanceof EquipasIguaisException) view.erros(1);
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
