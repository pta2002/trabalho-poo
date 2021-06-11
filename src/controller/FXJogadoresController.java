package controller;

import model.FootballManagerModel;
import view.FXJogadoresView;

public class FXJogadoresController {
    private FootballManagerModel model;
    private FXJogadoresView view;

    public FXJogadoresController(FootballManagerModel model, FXJogadoresView view) {
        this.model = model;
        this.view = view;
    }

    public void setEquipa(String equipa) {
        this.view.setJogadores(model.getEquipa(equipa).getJogadores());
    }
}
