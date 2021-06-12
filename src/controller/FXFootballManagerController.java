package controller;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import model.FootballManagerModel;
import view.*;

import java.io.IOException;

public class FXFootballManagerController implements ListChangeListener<String> {
    private FootballManagerModel model;
    private FXFootballManagerView view;

    private FXListaEquipasController equipasController;
    private FXEquipaController equipaController;
    private FXJogadoresController jogadoresController;

    public FXFootballManagerController(FootballManagerModel model, FXFootballManagerView view) throws IOException {
        this.model = model;
        this.view = view;

        FXListaEquipasView equipasView = new FXListaEquipasView();
        FXMLLoader equipasLoader = new FXMLLoader(getClass().getResource("/listaequipas.fxml"));
        equipasLoader.setController(equipasView);
        view.addListaEquipas(equipasLoader.load());
        equipasController = new FXListaEquipasController(model, equipasView);
        equipasController.addListener(this);

        FXEquipaView equipaView = new FXEquipaView();
        equipaController = new FXEquipaController(model, equipaView);
        this.view.addInfoEquipa(equipaView.getNode());

        FXJogadoresView jogadoresView = new FXJogadoresView();
        jogadoresController = new FXJogadoresController(model, jogadoresView);
        this.view.addListaJogadores(jogadoresView.getNode());

        this.view.setOnSimular(() -> {
            FXSimulacaoView sv = new FXSimulacaoView();
            FXSimulacaoController sc = new FXSimulacaoController(model, sv);
            try {
                sc.mostrarPopup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void executa() {
        equipaController.setEquipa(null);
    }

    @Override
    public void onChanged(Change<? extends String> c) {
        if (equipasController.getEquipasSelecionadas().size() > 0) {
            this.equipaController.setEquipa(equipasController.getEquipasSelecionadas().get(0));
            this.jogadoresController.setEquipa(equipasController.getEquipasSelecionadas().get(0));
        } else {
            this.equipaController.setEquipa(null);
        }
    }
}
