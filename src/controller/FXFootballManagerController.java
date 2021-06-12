package controller;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import model.FootballManagerModel;
import view.*;

import java.io.File;
import java.io.IOException;

public class FXFootballManagerController implements ListChangeListener<String> {
    private FootballManagerModel model;
    private FXFootballManagerView view;

    private FXListaEquipasController equipasController;
    private FXEquipaController equipaController;
    private FXJogadoresController jogadoresController;

    public FXFootballManagerController(FootballManagerModel model, FXFootballManagerView view) throws IOException {
        this.model = model;
        this.view = view;

        this.init();
    }

    public void executa() {
        equipaController.setEquipa(null);
    }

    @Override
    public void onChanged(Change<? extends String> c) {
        if (equipasController.getEquipasSelecionadas().size() > 0) {
            this.equipaController.setEquipa(equipasController.getEquipasSelecionadas().get(0));
            this.jogadoresController.setEquipa(equipasController.getEquipasSelecionadas().get(0));
        } else {
            this.equipaController.setEquipa(null);
        }
    }

    public void gravar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar ficheiro de objetos");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ficheiro de objetos", "*.obj"));
        File f = fileChooser.showSaveDialog(view.getRootWindow());
        if (f != null) {
            try {
                String path = f.getAbsolutePath();
                if (!path.endsWith(".obj"))
                    path = path + ".obj";
                model.writeObjectFile(path);
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Erro ao gravar");
                error.setHeaderText(e.getMessage());
                error.show();
            }
        }
    }

    public void abrir() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir logs/ficheiro de objetos");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos os ficheiros", "*.txt", "*.obj"),
                new FileChooser.ExtensionFilter("Ficheiro de logs", "*.txt"),
                new FileChooser.ExtensionFilter("Ficheiro de objetos", "*.obj"));
        File f = fileChooser.showOpenDialog(view.getRootWindow());
        if (f != null) {
            try {
                FootballManagerModel newModel = FootballManagerModel.load_from_file(f.getAbsolutePath());
                this.model = newModel;
                init();
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Erro ao abrir ficheiro");
                error.setHeaderText(e.getMessage());
                error.show();
            }
        }
    }

    private void init() throws IOException {
        FXListaEquipasView equipasView = new FXListaEquipasView();
        FXMLLoader equipasLoader = new FXMLLoader(getClass().getResource("/listaequipas.fxml"));
        equipasLoader.setController(equipasView);
        view.addListaEquipas(equipasLoader.load());
        equipasController = new FXListaEquipasController(model, equipasView);
        equipasController.addListener(this);

        FXEquipaView equipaView = new FXEquipaView();
        equipaController = new FXEquipaController(model, equipaView);
        this.view.addInfoEquipa(equipaView.getNode());

        FXJogadoresView jogadoresView = new FXJogadoresView();
        jogadoresController = new FXJogadoresController(model, jogadoresView);
        this.view.addListaJogadores(jogadoresView.getNode());

        this.view.setOnSimular(() -> {
            FXSimulacaoView sv = new FXSimulacaoView();
            FXSimulacaoController sc = new FXSimulacaoController(model, sv);
            try {
                sc.mostrarPopup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        this.view.setOnGravar(this::gravar);
        this.view.setOnAbrir(this::abrir);
    }
}
