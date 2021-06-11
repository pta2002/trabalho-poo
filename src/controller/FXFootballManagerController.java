package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FootballManagerModel;
import view.FXListaEquipasView;
import view.FootballManagerView;

import java.io.IOException;
import java.util.ArrayList;

public class FXFootballManagerController {
    private FootballManagerModel model;
    private FootballManagerView view;

    private FXListaEquipasController equipasController;

    public FXFootballManagerController(FootballManagerModel model, FootballManagerView view) throws IOException {
        this.model = model;
        this.view = view;

        FXListaEquipasView equipasView = new FXListaEquipasView();
        FXMLLoader equipasLoader = new FXMLLoader(getClass().getResource("/listaequipas.fxml"));
        equipasLoader.setController(equipasView);
        view.addListaEquipas(equipasLoader.load());
        equipasController = new FXListaEquipasController(model, equipasView);
    }

    public void executa() {
        //
    }
}
