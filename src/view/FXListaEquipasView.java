package view;

import controller.interfaces.ICallbackUm;
import controller.interfaces.ICallbackZero;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Jogador.Jogador;

import java.util.List;
import java.util.stream.Collectors;

public class FXListaEquipasView {
    @FXML
    private ListView<String> lista;

    public FXListaEquipasView() {
        lista = new ListView<>();
    }

    private ICallbackZero onAdicionar;
    private ICallbackUm<String> onApagar;

    public void setEquipas(List<String> equipas) {
        lista.setCellFactory(e -> {
            ListCell<String> cell = new ListCell<>();
            MenuItem apagar = new MenuItem("Apagar");
            apagar.setOnAction(event -> {
                if (!cell.isEmpty()) {
                    String equipa = cell.getItem();
                    if (this.onApagar != null)
                        this.onApagar.run(equipa);
                }
            });
            cell.setContextMenu(new ContextMenu(apagar));
            cell.textProperty().bind(cell.itemProperty());
            return cell;
        });
        lista.getItems().setAll(equipas.stream().sorted().collect(Collectors.toList()));
    }

    public void setOnAdicionar(ICallbackZero onAdicionar) {
        this.onAdicionar = onAdicionar;
    }

    public void setOnApagar(ICallbackUm<String> onApagar) {
        this.onApagar = onApagar;
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
