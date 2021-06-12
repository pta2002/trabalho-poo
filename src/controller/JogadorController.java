package controller;

import controller.interfaces.ICallbackZero;
import javafx.scene.control.Alert;
import model.FootballManagerModel;
import model.Jogador.Jogador;
import view.FXJogadorView;

import java.io.IOException;

public class JogadorController {
    private FootballManagerModel model;
    private FXJogadorView view;
    private String equipa;
    private ICallbackZero onGravar;
    private Jogador jogador;

    public JogadorController(FootballManagerModel model, FXJogadorView view, String equipa) {
        this.model = model;
        this.view = view;
        this.equipa = equipa;
        this.view.setOnGravar(this::gravar);
    }

    public void setOnGravar(ICallbackZero onGravar) {
        this.onGravar = onGravar;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public void mostrarPopup() throws IOException {
        this.view.mostra();
    }

    private void gravar(Jogador j) {
        if (model.getEquipa(equipa).getJogador(j.getNumeroJogador()) != null && (jogador == null || jogador.getNumeroJogador() != j.getNumeroJogador())) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Jogador já existe");
            err.setHeaderText("Já existe um jogador com este número");
            err.show();
        } else {
            if (jogador != null) {
                model.getEquipa(equipa).removeJogador(jogador);
            }
            model.insereJogador(j, equipa);
            this.onGravar.run();
            view.fecha();
        }
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        this.view.setJogador(jogador);
    }
}
