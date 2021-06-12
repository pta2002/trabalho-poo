package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Jogador.Defesa;
import model.Jogador.Jogador;
import model.Jogo.PosicaoJogador;

import java.io.IOException;
import java.util.List;

public class FXJogadoresView {
    @FXML
    private Label labelJogadores;
    @FXML
    private TableView<Jogador> jogadores;

    FXMLLoader loader;

    public FXJogadoresView() {
        loader = new FXMLLoader(getClass().getResource("/listajogadores.fxml"));
        jogadores = new TableView<>();

        loader.setController(this);
    }

    public VBox getNode() throws IOException {
        VBox box = loader.load();

        TableColumn<Jogador, Integer> colunaNumero = new TableColumn<>("Nº");
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numeroJogador"));
        TableColumn<Jogador, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nomeJogado"));
        TableColumn<Jogador, Double> colunaHabilidade = new TableColumn<>("Habilidade");
        colunaHabilidade.setCellValueFactory(new PropertyValueFactory<>("habilidade"));

        jogadores.getColumns().addAll(colunaNumero, colunaNome, colunaHabilidade);
        return box;
    }

    public void setJogadores(List<Jogador> j) {
        jogadores.getItems().clear();
        jogadores.getItems().addAll(j);
    }
}
