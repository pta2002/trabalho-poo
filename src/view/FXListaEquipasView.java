package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.stream.Collectors;

public class FXListaEquipasView {
    @FXML
    private ListView<String> lista;

    public FXListaEquipasView() {
        lista = new ListView<>();
    }

    public void setEquipas(List<String> equipas) {
        lista.getItems().setAll(equipas.stream().sorted().collect(Collectors.toList()));
    }
}
