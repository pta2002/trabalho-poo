package controller;

import model.FootballManagerModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Menu {
    protected List<String> opcoes;
    protected int op;

    abstract public void executa(FootballManagerModel model);

    protected void showMenu() {
        System.out.println("\n +------------| Football Manager Menu |-----------+ \n");
        for (int i=0; i<this.opcoes.size(); i++) {
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
    }
    static int showMenuReadOption(List<String> opcoes) {
        System.out.println("\n +------------| Football Manager Menu |-----------+ \n");
        for (int i=0; i<opcoes.size(); i++) {
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(opcoes.get(i));
        }
        System.out.println("0 - Sair");
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("\nOpção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) {
            op = -1;
        }
        if (op<0 || op>opcoes.size()) {
            System.out.println("Opção inválida!!!");
            op = -1;
        }

        return op;
    }

    protected int lerOpcao() {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("\nOpção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) {
            op = -1;
        }
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção inválida!!!");
            op = -1;
        }

        return op;
    }

    protected int getOpcao() {
        return this.op;
    }
}