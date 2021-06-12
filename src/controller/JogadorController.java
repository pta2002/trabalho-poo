package controller;

import controller.interfaces.ICallbackUm;
import controller.interfaces.ICallbackZero;
import model.FootballManagerModel;
import model.Jogador.Jogador;
import view.JogadorView;

import java.io.IOException;

public class JogadorController {
    private FootballManagerModel model;
    private JogadorView view;
    private String equipa;
    private ICallbackZero onGravar;

    public JogadorController(FootballManagerModel model, JogadorView view, String equipa) {
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
        model.insereJogador(j, equipa);
        this.onGravar.run();
        view.fecha();
    }
}
