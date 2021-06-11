package controller;

import model.FootballManagerModel;
import view.FXListaEquipasView;

import java.util.ArrayList;

public class FXListaEquipasController {
    private FootballManagerModel model;
    private FXListaEquipasView view;

    public FXListaEquipasController(FootballManagerModel model, FXListaEquipasView view) {
        this.model = model;
        this.view = view;

        this.view.setEquipas(new ArrayList<>(model.getEquipas().keySet()));
    }
}
