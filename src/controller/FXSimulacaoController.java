package controller;

import model.FootballManagerModel;
import view.FXSimulacaoView;

import java.io.IOException;

public class FXSimulacaoController {
    private FootballManagerModel model;
    private FXSimulacaoView view;

    public FXSimulacaoController(FootballManagerModel model, FXSimulacaoView view) {
        this.model = model;
        this.view = view;
    }

    public void mostrarPopup() throws IOException {
        this.view.mostra();
    }
}
