package controller;

import model.FootballManagerModel;
import model.Jogador.*;
import view.EquipaView;
import view.JogadoresView;

import java.util.ArrayList;
import java.util.Scanner;

public class JogadoresController extends Menu {

    @Override
    public void executa(FootballManagerModel model) {
        int numeroJ, vel, res, des, imp, cab, rem, p;
        Scanner is = new Scanner(System.in);
        JogadoresView view = new JogadoresView();
        EquipaView equipaView = new EquipaView();

        view.border();
        view.mensagens(1);
        String nomeJ = is.nextLine();

        view.mensagens(2);
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

        view.mensagens(3);
        numeroJ = is.nextInt();
        is.nextLine();

        view.mensagens(4);
        vel = is.nextInt();
        is.nextLine();

        view.mensagens(5);
        res = is.nextInt();
        is.nextLine();

        view.mensagens(6);
        des = is.nextInt();
        is.nextLine();

        view.mensagens(7);
        imp = is.nextInt();
        is.nextLine();

        view.mensagens(8);
        cab = is.nextInt();
        is.nextLine();

        view.mensagens(9);
        rem = is.nextInt();
        is.nextLine();

        view.mensagens(10);
        p = is.nextInt();
        is.nextLine();

        view.mensagens(14);
        StringBuilder equipa = new StringBuilder();
        equipa.append(is.nextLine());

        while (model.existeEquipa(equipa.toString()) == false) {
            equipaView.errosEquipa(1);
            equipa.delete(0,equipa.length());
            equipa.append(is.nextLine());
        }

        if (posicaoJ.toString().equals("GuardaRedes")) {
            view.mensagens(11);
            int elasticidade = is.nextInt();
            GuardaRedes guardaRedes = new GuardaRedes(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, elasticidade, new ArrayList<>());
            model.insereJogador(guardaRedes,equipa.toString());

        }

        if (posicaoJ.toString().equals("Defesa")) {
            Defesa defesa = new Defesa(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, new ArrayList<>());
            model.insereJogador(defesa,equipa.toString());
        }

        if (posicaoJ.toString().equals("Lateral")) {
            view.mensagens(12);
            int cruzamento = is.nextInt();
            Lateral lateral = new Lateral(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, cruzamento, new ArrayList<>());
            model.insereJogador(lateral,equipa.toString());
        }

        if (posicaoJ.toString().equals("Medio")) {
            view.mensagens(13);
            int recuperacao = is.nextInt();
            Medio medio = new Medio(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, recuperacao, new ArrayList<>());
            model.insereJogador(medio,equipa.toString());
        }

        if (posicaoJ.toString().equals("Avancado")) {
            Avancado avancado = new Avancado(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p, new ArrayList<>());
            model.insereJogador(avancado,equipa.toString());
        }

    }
}
