package view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FootballManagerView {
    @FXML
    private VBox equipas;

    public FootballManagerView() {
        equipas = new VBox();
    }

    public void addListaEquipas(VBox lista) {
        lista.setFillWidth(true);
        equipas.getChildren().add(lista);
        VBox.setVgrow(lista, Priority.ALWAYS);
    }
}
