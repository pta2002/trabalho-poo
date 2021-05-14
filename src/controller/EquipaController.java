package controller;

import model.FootballManagerModel;
import view.EquipaView;
import view.JogadoresView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EquipaController extends Menu {

    public EquipaController() {
        super.opcoes = new ArrayList<>();
        super.op = 0;
    }

    public EquipaController(String[] opcoes) {
        super.opcoes = Arrays.asList(opcoes);
        super.op = 0;
    }

    @Override
    public void executa(FootballManagerModel model) {
        Scanner is = new Scanner(System.in);
        EquipaView view = new EquipaView();
        do {
            view.border(1);
            view.mensagens(1);
            StringBuilder equipa = new StringBuilder();
            equipa.append(is.nextLine());

            while (model.existeEquipa(equipa.toString()) == false) {
                view.errosEquipa(1);
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

    public void criarEquipa(FootballManagerModel model) {
        EquipaView view = new EquipaView();
        view.border(2);
        view.mensagens(2);

        Scanner is = new Scanner(System.in);
        StringBuilder equipa = new StringBuilder();
        equipa.append(is.nextLine());

        while (model.existeEquipa(equipa.toString()) == true) {
            view.errosEquipa(2);
            equipa.delete(0,equipa.length());
            equipa.append(is.nextLine());
        }

        model.insereEquipa(equipa.toString());
    }
}
