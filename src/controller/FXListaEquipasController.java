package controller;

import javafx.collections.ListChangeListener;
import model.FootballManagerModel;
import view.FXListaEquipasView;

import java.util.ArrayList;
import java.util.List;

public class FXListaEquipasController {
    private FootballManagerModel model;
    private FXListaEquipasView view;

    public FXListaEquipasController(FootballManagerModel model, FXListaEquipasView view) {
        this.model = model;
        this.view = view;

        this.view.setEquipas(new ArrayList<>(model.getEquipas().keySet()));
    }

    /**
     * Adiciona um listener para a mudança de equipa
     * @param listener O listener
     */
    public void addListener(ListChangeListener<String> listener) {
        this.view.getEquipasSelecionadas().addListener(listener);
    }

    public List<String> getEquipasSelecionadas() {
        return this.view.getEquipasSelecionadas();
    }
}
