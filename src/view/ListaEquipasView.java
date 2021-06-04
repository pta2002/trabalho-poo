package view;

import model.Equipa.Equipa;
import model.FootballManagerModel;

import java.util.Map;

public class ListaEquipasView {
    public void mostrarListaEquipas(Map<String, Equipa> equipas) {
        equipas.keySet().forEach(System.out::println);
    }
}
