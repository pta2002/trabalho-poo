package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Equipa.Equipa;

import java.io.IOException;
import java.text.NumberFormat;

public class FXEquipaView {
    @FXML
    private Label mediaDefesas;
    @FXML
    private Label mediaMedios;
    @FXML
    private Label mediaAvancados;
    @FXML
    private Label mediaTotal;
    @FXML
    private Label nomeEquipa;
    @FXML
    private GridPane shownGrid;

    private FXMLLoader loader;
    Node node;

    public FXEquipaView() {
        loader = new FXMLLoader(getClass().getResource("/equipa.fxml"));

        mediaDefesas = new Label();
        mediaMedios = new Label();
        mediaAvancados = new Label();
        mediaTotal = new Label();
        nomeEquipa = new Label();
        shownGrid = new GridPane();

        loader.setController(this);
    }

    public Node getNode() throws IOException {
        return loader.load();
    }

    public void mostraEquipa(Equipa equipa) {
        if (equipa == null) {
            shownGrid.setVisible(false);
            nomeEquipa.setText("Nenhuma equipa selecionada");
        } else {
            shownGrid.setVisible(true);
            nomeEquipa.setText(equipa.getNome());
            mediaMedios.setText(NumberFormat.getInstance().format(equipa.getMediosOverall()));
            mediaDefesas.setText(NumberFormat.getInstance().format(equipa.getDefesaOverall()));
            mediaAvancados.setText(NumberFormat.getInstance().format(equipa.getAvancadosOverall()));
            mediaTotal.setText(NumberFormat.getInstance().format(equipa.getOverall()));
        }
    }
}
