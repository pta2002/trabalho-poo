package view;

import controller.interfaces.ICallbackUm;
import controller.interfaces.ICallbackZero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Equipa.Equipa;
import model.Jogo.Evento.EventoJogo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXSimulacaoView {
    private FXMLLoader loader;
    private Stage popUp;

    private List<String> equipas;

    @FXML
    private ChoiceBox<String> listaCasa;
    @FXML
    private ChoiceBox<String> listaFora;
    @FXML
    private CheckBox aleatorioCasa;
    @FXML
    private CheckBox aleatorioFora;
    @FXML
    private Button configurarCasa;
    @FXML
    private Button configurarFora;
    @FXML
    private ListView<EventoJogo> listaEventos;

    private ICallbackUm<String> onConfigCasa;
    private ICallbackUm<String> onConfigFora;
    private ICallbackZero onSimular;

    public FXSimulacaoView() {
        loader = new FXMLLoader(getClass().getResource("/simulacao.fxml"));
        loader.setController(this);

        popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setTitle("Simulação");
    }

    public void setEquipas(List<String> equipas) {
        this.equipas = new ArrayList<>(equipas);
    }

    public void setOnConfigCasa(ICallbackUm<String> onConfigCasa) {
        this.onConfigCasa = onConfigCasa;
    }

    public void setOnConfigFora(ICallbackUm<String> onConfigFora) {
        this.onConfigFora = onConfigFora;
    }

    public void setOnSimular(ICallbackZero onSimular) {
        this.onSimular = onSimular;
    }

    public void mostra() throws IOException {
        popUp.setScene(new Scene(loader.load()));

        listaCasa.getItems().setAll(equipas);
        listaFora.getItems().setAll(equipas);

        configurarCasa.setDisable(true);
        configurarFora.setDisable(true);

        popUp.show();
    }

    public boolean getAleatorioCasa() {
        return aleatorioCasa.selectedProperty().getValue();
    }

    public boolean getAleatorioFora() {
        return aleatorioFora.selectedProperty().getValue();
    }

    public void clearEventos() {

    }

    public void addEvento(EventoJogo e) {
        listaEventos.getItems().add(e.clone());
    }

    @FXML
    private void ativarCasa() {
        if (getAleatorioCasa() || this.listaCasa.getValue() == null) {
            configurarCasa.setDisable(true);
        } else {
            configurarCasa.setDisable(false);
        }
    }

    @FXML
    private void ativarFora() {
        if (getAleatorioFora() || this.listaFora.getValue() == null) {
            configurarFora.setDisable(true);
        } else {
            configurarFora.setDisable(false);
        }
    }

    @FXML
    private void configFora() {
        if (onConfigFora != null)
            onConfigFora.run(listaFora.getValue());
    }

    @FXML
    private void configCasa() {
        if (onConfigCasa != null)
            onConfigCasa.run(listaCasa.getValue());
    }

    @FXML
    private void simular() {
        if (onSimular != null)
            onSimular.run();
    }

    public String getEquipaCasa() {
        return listaCasa.getValue();
    }

    public String getEquipaFora() {
        return listaFora.getValue();
    }
}
