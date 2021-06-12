package view;

import controller.interfaces.ICallbackZero;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.List;
import java.util.stream.Collectors;

public class FXListaEquipasView {
    @FXML
    private ListView<String> lista;

    public FXListaEquipasView() {
        lista = new ListView<>();
    }

    private ICallbackZero onAdicionar;

    public void setEquipas(List<String> equipas) {
        lista.getItems().setAll(equipas.stream().sorted().collect(Collectors.toList()));
    }

    public void setOnAdicionar(ICallbackZero onAdicionar) {
        this.onAdicionar = onAdicionar;
    }

    public ObservableList<String> getEquipasSelecionadas() {
        return lista.getSelectionModel().getSelectedItems();
    }

    public String getNomeNovaEquipa() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Nome da equipa");
        dialog.setTitle("Criar equipa");
        return dialog.showAndWait().orElse(null);
    }

    @FXML
    private void addEquipa() {
        if (this.onAdicionar != null) {
            this.onAdicionar.run();
        }
    }
}
