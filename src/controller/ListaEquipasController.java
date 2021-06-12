package controller;

import model.Equipa.Equipa;
import model.FootballManagerModel;
import view.ListaEquipasView;

public class ListaEquipasController {
    public void executa(FootballManagerModel model) {
        ListaEquipasView v = new ListaEquipasView();
        v.mostrarListaEquipas(model.getEquipas());
    }
}
