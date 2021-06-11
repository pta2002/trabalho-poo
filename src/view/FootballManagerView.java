package view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Equipa.Equipa;

public class FootballManagerView {
    @FXML
    private VBox equipas;

    @FXML
    private ScrollPane infoEquipa;

    public FootballManagerView() {
        equipas = new VBox();
        infoEquipa = new ScrollPane();
    }

    public void addListaEquipas(VBox lista) {
        lista.setFillWidth(true);
        equipas.getChildren().add(lista);
        VBox.setVgrow(lista, Priority.ALWAYS);
    }

    public void addInfoEquipa(Node equipa) {
        infoEquipa.setContent(equipa);
    }
}
