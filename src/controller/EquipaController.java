package controller;

import model.FootballManagerModel;
import view.EquipaView;
import view.JogadoresView;

import java.util.Arrays;
import java.util.Scanner;

public class EquipaController extends Menu {

    public EquipaController(String[] opcoes) {
        super.opcoes = Arrays.asList(opcoes);
        super.op = 0;
    }

    @Override
    public void executa(FootballManagerModel model) {
        Scanner is = new Scanner(System.in);
        JogadoresView jview = new JogadoresView();
        EquipaView view = new EquipaView();
        do {
            view.equipaMenu(1);
            StringBuilder equipa = new StringBuilder();
            equipa.append(is.nextLine());

            while (model.existeEquipa(equipa.toString()) == false) {
                jview.errosJogador(1);
                equipa.delete(0,equipa.length());
                equipa.append(is.nextLine());
            }

            showMenu();
            this.op = lerOpcao();
            switch (op) {
                case 1:
                    view.mostrarEquipa(model.getEquipa(equipa.toString()));
                    break;
                case 2:
                    view.mostrarOverall(model.getEquipa(equipa.toString()));
                    break;
                case 3:
                    break;
                default:break;
            }
        } while (this.op != 0);
    }
}
