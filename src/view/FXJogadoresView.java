package view;

import controller.interfaces.ICallbackUm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Jogador.Jogador;

import java.io.IOException;
import java.util.List;

public class FXJogadoresView {
    @FXML
    private Label labelJogadores;
    @FXML
    private TableView<Jogador> jogadores;
    @FXML
    private Button adicionarJogador;

    FXMLLoader loader;
    private ICallbackUm<Void> callback;

    public FXJogadoresView() {
        loader = new FXMLLoader(getClass().getResource("/listajogadores.fxml"));
        jogadores = new TableView<>();

        loader.setController(this);
    }

    public void setCallback(ICallbackUm<Void> callback) {
        this.callback = callback;
    }

    public VBox getNode() throws IOException {
        VBox box = loader.load();

        TableColumn<Jogador, Integer> colunaNumero = new TableColumn<>("Nº");
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numeroJogador"));
        TableColumn<Jogador, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nomeJogador"));
        TableColumn<Jogador, Double> colunaPosicao = new TableColumn<>("Posição");
        colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        TableColumn<Jogador, Double> colunaHabilidade = new TableColumn<>("Habilidade");
        colunaHabilidade.setCellValueFactory(new PropertyValueFactory<>("habilidade"));

        jogadores.getColumns().addAll(colunaNumero, colunaPosicao, colunaNome, colunaHabilidade);
        return box;
    }

    public void setJogadores(List<Jogador> j) {
        jogadores.getItems().clear();
        jogadores.getItems().addAll(j);
    }

    @FXML
    public void adicionar() {
        if (callback != null) {
            callback.run(null);
        }
    }
}
