package controller;

import model.FootballManagerModel;
import model.Jogador.Jogador;
import view.EquipaView;
import view.JogadoresView;
import view.TransferenciasView;

import java.util.Scanner;

public class TransferenciasController extends Menu{
    @Override
    public void executa(FootballManagerModel model) {
        TransferenciasView transferenciasView = new TransferenciasView();
        JogadoresView jogadoresView = new JogadoresView();
        EquipaView equipaView = new EquipaView();
        Scanner is = new Scanner(System.in);

        transferenciasView.border(1);
        transferenciasView.mensagens(1);

        StringBuilder equipa = new StringBuilder();
        equipa.append(is.nextLine());
        while (model.existeEquipa(equipa.toString()) == false) {
            equipaView.errosEquipa(1);
            equipa.delete(0,equipa.length());
            equipa.append(is.nextLine());
        }

        jogadoresView.mensagens(3);

        int numeroCamisola = 0;
        numeroCamisola = is.nextInt();
        is.nextLine();

        while (model.getEquipa(equipa.toString()).existeJogador(numeroCamisola) == false) {
            jogadoresView.errosJogador(1);
            numeroCamisola = is.nextInt();
            is.nextLine();
        }

        transferenciasView.mensagens(2);

        StringBuilder equipaTransferir = new StringBuilder();
        equipaTransferir.append(is.nextLine());
        while (model.existeEquipa(equipaTransferir.toString()) == false) {
            equipaView.errosEquipa(1);
            equipaTransferir.delete(0,equipa.length());
            equipaTransferir.append(is.nextLine());
        }

        transfereJogador(model, equipa.toString(), equipaTransferir.toString(), numeroCamisola);

    }

    private void transfereJogador(FootballManagerModel model, String equipaOriginal, String equipaTransferir, int numeroCamisola) {
        Scanner is = new Scanner(System.in);
        int novoNumero = numeroCamisola;

        TransferenciasView view = new TransferenciasView();
        Jogador jogador = model.getEquipa(equipaOriginal).getJogador(numeroCamisola);
        model.getEquipa(equipaOriginal).removeJogador(jogador);

        while (model.getEquipa(equipaTransferir).existeJogador(novoNumero)) {
            view.errosTransferencia(1);
            novoNumero = is.nextInt();
        }

        jogador.setNumeroJogador(novoNumero);
        model.getEquipa(equipaTransferir).insereJogador(jogador);
    }
}
