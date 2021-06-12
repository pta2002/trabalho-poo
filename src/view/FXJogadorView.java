package view;

import controller.interfaces.ICallbackUm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Jogador.*;
import model.Jogo.PosicaoJogador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXJogadorView {
    @FXML
    private ChoiceBox<PosicaoJogador> posicaoJogador;
    @FXML
    private TextInputControl nomeJogador;
    @FXML
    private TextInputControl numJogador;
    @FXML
    private Slider velocidade;
    @FXML
    private Slider resistencia;
    @FXML
    private Slider destreza;
    @FXML
    private Slider impulsao;
    @FXML
    private Slider cabeca;
    @FXML
    private Slider remate;
    @FXML
    private Slider passe;
    @FXML
    private Slider especial;
    @FXML
    private Label especialLabel;
    @FXML
    private TableView<EntradaHistorial> historialEquipas;

    private List<String> equipas;

    private Stage popUp;
    private FXMLLoader loader;

    private ICallbackUm<Jogador> onGravar;

    public FXJogadorView() {
        loader = new FXMLLoader(getClass().getResource("/jogador.fxml"));
        loader.setController(this);

        popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setTitle("Novo jogador");
    }

    public void setEquipas(List<String> equipas) {
        this.equipas = new ArrayList<>(equipas);
    }

    public void setEspecial(String nome) {
        if (nome == null) {
            especialLabel.setVisible(false);
            especial.setVisible(false);
        } else {
            especialLabel.setVisible(true);
            especialLabel.setText(nome);
            especial.setVisible(true);
        }
    }

    public void mostra() throws IOException {
        popUp.setScene(new Scene(loader.load()));
        posicaoJogador.getItems().addAll(PosicaoJogador.AVANCADO, PosicaoJogador.DEFESA, PosicaoJogador.MEDIO, PosicaoJogador.LATERAL, PosicaoJogador.GUARDA_REDES);
        posicaoJogador.setValue(PosicaoJogador.AVANCADO);

        TableColumn<EntradaHistorial, String> colunaEquipa = new TableColumn<>("Equipa");
        colunaEquipa.setCellValueFactory(new PropertyValueFactory<>("equipa"));
        TableColumn<EntradaHistorial, String> colunaNumero = new TableColumn<>("Nº");
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

        posicaoJogador.setOnAction(e-> {
            switch (posicaoJogador.getValue()) {
                case GUARDA_REDES:
                    setEspecial("Elasticidade");
                    break;
                case MEDIO:
                    setEspecial("Recuperação");
                    break;
                case LATERAL:
                    setEspecial("Cruzamento");
                    break;
                default:
                    setEspecial(null);
                    break;
            }
        });

        historialEquipas.getColumns().addAll(colunaEquipa, colunaNumero);
        setEspecial(null);

        popUp.show();
    }

    public void fecha() {
        popUp.close();
    }

    public void setOnGravar(ICallbackUm<Jogador> onGravar) {
        this.onGravar = onGravar;
    }

    @FXML
    private void gravar() {
        if (this.onGravar != null) {
            Jogador j;

            String nomeJogador = this.nomeJogador.getText();
            int num = 0;
            try {
                num = Integer.parseInt(this.numJogador.getText());
            } catch (NumberFormatException e) {
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("Número de jogador inválido");
                err.setHeaderText("Número do jogador é inválido");
                err.show();
            }
            int velocidade = (int) this.velocidade.getValue();
            int resistencia = (int) this.resistencia.getValue();
            int destreza = (int) this.destreza.getValue();
            int impulsao = (int) this.impulsao.getValue();
            int cabeca = (int) this.cabeca.getValue();
            int remate = (int) this.remate.getValue();
            int passe = (int) this.passe.getValue();
            int especial = (int) this.especial.getValue();

            switch (posicaoJogador.getValue()) {
               case MEDIO:
                    j = new Medio(nomeJogador, num, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, especial, new ArrayList<>());
                    break;
                case DEFESA:
                    j = new Defesa(nomeJogador, num, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, new ArrayList<>());
                    break;
                case GUARDA_REDES:
                    j = new GuardaRedes(nomeJogador, num, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, especial, new ArrayList<>());
                    break;
                case LATERAL:
                    j = new Lateral(nomeJogador, num, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, especial, new ArrayList<>());
                    break;
                default:
                    j = new Avancado(nomeJogador, num, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, new ArrayList<>());
                    break;
            }

            this.onGravar.run(j);
        }
    }

    @FXML
    private void cancelar() {
        popUp.close();
    }
}
