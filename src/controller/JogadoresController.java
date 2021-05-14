package controller;

import model.FootballManagerModel;
import model.Jogador.*;
import view.JogadoresView;

import java.util.Scanner;

public class JogadoresController extends Menu {

    @Override
    public void executa(FootballManagerModel model) {
        Scanner is = new Scanner(System.in);
        int numeroJ, vel, res, des, imp, cab, rem, p;
        JogadoresView view = new JogadoresView();

        view.border();
        view.CriarJogadorMenu(1);
        String nomeJ = is.nextLine();

        view.CriarJogadorMenu(2);
        StringBuilder posicaoJ = new StringBuilder();
        posicaoJ.append(is.nextLine());

        while (((posicaoJ.toString().equals("GuardaRedes")) == false)
                && ((posicaoJ.toString().equals("Defesa")) == false)
                && ((posicaoJ.toString().equals("Lateral")) == false)
                && ((posicaoJ.toString().equals("Medio")) == false)
                && ((posicaoJ.toString().equals("Avancado")) == false)) {
            view.errosJogador(2);
            posicaoJ.delete(0,posicaoJ.length());
            posicaoJ.append(is.nextLine());

        }

        view.CriarJogadorMenu(3);
        numeroJ = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(4);
        vel = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(5);
        res = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(6);
        des = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(7);
        imp = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(8);
        cab = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(9);
        rem = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(10);
        p = is.nextInt();
        is.nextLine();

        view.CriarJogadorMenu(14);
        StringBuilder equipa = new StringBuilder();
        equipa.append(is.nextLine());

        while (model.existeEquipa(equipa.toString()) == false) {
            view.errosJogador(1);
            equipa.delete(0,equipa.length());
            equipa.append(is.nextLine());

        }

        if (posicaoJ.toString().equals("GuardaRedes")) {
            view.CriarJogadorMenu(11);
            int elasticidade = is.nextInt();
            GuardaRedes guardaRedes = new GuardaRedes(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, elasticidade);
            model.insereJogador(guardaRedes,equipa.toString());

        }

        if (posicaoJ.toString().equals("Defesa")) {
            Defesa defesa = new Defesa(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p);
            model.insereJogador(defesa,equipa.toString());
        }

        if (posicaoJ.toString().equals("Lateral")) {
            view.CriarJogadorMenu(12);
            int cruzamento = is.nextInt();
            Lateral lateral = new Lateral(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, cruzamento);
            model.insereJogador(lateral,equipa.toString());
        }

        if (posicaoJ.toString().equals("Medio")) {
            view.CriarJogadorMenu(13);
            int recuperacao = is.nextInt();
            Medio medio = new Medio(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, recuperacao);
            model.insereJogador(medio,equipa.toString());
        }

        if (posicaoJ.toString().equals("Avancado")) {
            Avancado avancado = new Avancado(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p);
            model.insereJogador(avancado,equipa.toString());
        }

    }
}
