package view;

import controller.interfaces.ICallbackZero;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import model.Equipa.Equipa;

public class FXFootballManagerView {
    @FXML
    private VBox equipas;

    @FXML
    private ScrollPane infoEquipa;

    @FXML
    private VBox listaJogadores;

    private Window rootWindow;
    private ICallbackZero onSimular;
    private ICallbackZero onAbrir;
    private ICallbackZero onGravar;

    public FXFootballManagerView(Window rootWindow) {
        equipas = new VBox();
        infoEquipa = new ScrollPane();
        this.rootWindow = rootWindow;
    }

    public void addListaEquipas(VBox lista) {
        lista.setFillWidth(true);
        equipas.getChildren().clear();
        equipas.getChildren().add(lista);
        VBox.setVgrow(lista, Priority.ALWAYS);
    }

    public void setOnSimular(ICallbackZero onSimular) {
        this.onSimular = onSimular;
    }

    public void setOnAbrir(ICallbackZero onAbrir) {
        this.onAbrir = onAbrir;
    }

    public void setOnGravar(ICallbackZero onGravar) {
        this.onGravar = onGravar;
    }

    public Window getRootWindow() {
        return rootWindow;
    }

    public void addInfoEquipa(Node equipa) {
        infoEquipa.setContent(equipa);
    }

    public void addListaJogadores(VBox jogadoresView) {
        jogadoresView.setFillWidth(true);
        listaJogadores.getChildren().clear();
        listaJogadores.getChildren().add(jogadoresView);
        VBox.setVgrow(listaJogadores, Priority.ALWAYS);
    }

    @FXML
    private void simular() {
        if (this.onSimular != null)
            this.onSimular.run();
    }

    @FXML
    private void abrir() {
        if (this.onAbrir != null)
            this.onAbrir.run();
    }

    @FXML
    private void gravar() {
        if (this.onGravar != null)
            this.onGravar.run();
    }
}
