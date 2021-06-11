package controller;

import model.FootballManagerModel;
import view.FXEquipaView;

public class FXEquipaController {
    private FootballManagerModel model;
    private FXEquipaView view;
    private String equipa;

    public FXEquipaController(FootballManagerModel model, FXEquipaView view) {
        this.model = model;
        this.view = view;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
        this.view.mostraEquipa(model.getEquipa(equipa));
    }
}
