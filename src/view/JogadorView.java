package view;

import controller.interfaces.ICallbackDois;
import controller.interfaces.ICallbackUm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Jogador.*;
import model.Jogo.PosicaoJogador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JogadorView {
    @FXML
    private ChoiceBox<PosicaoJogador> posicaoJogador;
    @FXML
    private TextInputControl nomeJogador;
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
    private Slider elasticidade;

    private List<String> equipas;

    private Stage popUp;
    private FXMLLoader loader;

    private ICallbackUm<Jogador> onGravar;

    public JogadorView() {
        loader = new FXMLLoader(getClass().getResource("/jogador.fxml"));
        loader.setController(this);

        popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setTitle("Novo jogador");
    }

    public void setEquipas(List<String> equipas) {
        this.equipas = new ArrayList<>(equipas);
    }

    public void mostra() throws IOException {
        popUp.setScene(new Scene(loader.load()));
        posicaoJogador.getItems().addAll(PosicaoJogador.GUARDA_REDES, PosicaoJogador.AVANCADO, PosicaoJogador.DEFESA, PosicaoJogador.MEDIO, PosicaoJogador.LATERAL);
        posicaoJogador.setValue(PosicaoJogador.AVANCADO);
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
            int velocidade = (int) this.velocidade.getValue();
            int resistencia = (int) this.resistencia.getValue();
            int destreza = (int) this.destreza.getValue();
            int impulsao = (int) this.impulsao.getValue();
            int cabeca = (int) this.cabeca.getValue();
            int remate = (int) this.remate.getValue();
            int passe = (int) this.passe.getValue();
            int elasticidade = (int) this.elasticidade.getValue();
            int recuperacao = 10; // TODO
            int cruzamento = 10; // TODO

            switch (posicaoJogador.getValue()) {
               case MEDIO:
                    j = new Medio(nomeJogador, 10, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, recuperacao, new ArrayList<>());
                    break;
                case DEFESA:
                    j = new Defesa(nomeJogador, 10, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, new ArrayList<>());
                    break;
                case GUARDA_REDES:
                    j = new GuardaRedes(nomeJogador, 10, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, elasticidade, new ArrayList<>());
                    break;
                case LATERAL:
                    j = new Lateral(nomeJogador, 10, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, cruzamento, new ArrayList<>());
                    break;
                default:
                    j = new Avancado(nomeJogador, 10, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe, new ArrayList<>());
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
