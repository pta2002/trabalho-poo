package controller;

import model.FootballManagerModel;
import model.Jogador.Jogador;
import view.FXJogadoresView;
import view.FXJogadorView;

import java.io.IOException;

public class FXJogadoresController {
    private FootballManagerModel model;
    private FXJogadoresView view;
    private String equipa;

    public FXJogadoresController(FootballManagerModel model, FXJogadoresView view) {
        this.model = model;
        this.view = view;

        this.view.setCallback(v -> {
            edit(null);
        });

        this.view.setOnEdit(this::edit);
    }

    private void edit(Jogador jogador) {
        if (this.equipa != null) {
            FXJogadorView jv = new FXJogadorView();
            JogadorController jc = new JogadorController(model, jv, this.equipa);
            jc.setJogador(jogador);
            jc.setOnGravar(() -> this.setEquipa(equipa));
            try {
                jc.mostrarPopup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
        this.view.setJogadores(model.getEquipa(equipa).getJogadores());
    }
}
