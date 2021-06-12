package view;

import controller.interfaces.ICallbackTres;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.Equipa.Equipa;
import model.Jogador.Jogador;
import model.Jogo.ModeloTatico;
import model.Jogo.PosicaoJogador;
import model.Jogo.SetupEquipa;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FXSetUpView {
    private Stage popUp;
    private FXMLLoader loader;

    @FXML
    private ChoiceBox<ModeloTatico> modeloTatico;
    @FXML
    private GridPane grelha;
    @FXML
    private ChoiceBox<Jogador> aSubstituir;
    @FXML
    private ChoiceBox<Jogador> substituirPor;
    @FXML
    private GridPane tabelaSubstituicoes;

    private SetupEquipa setup;
    private Map<Integer, Integer> substituicoes;

    private List<ChoiceBox<Jogador>> dropdowns;
    private Equipa equipa;

    private ICallbackTres<Map<Integer, Integer>, List<Integer>, ModeloTatico> onGravar;

    public FXSetUpView(Equipa equipa) {
        loader = new FXMLLoader(getClass().getResource("/setup.fxml"));
        loader.setController(this);
        popUp = new Stage();
        popUp.setTitle("Configurar set up de " + equipa);
        this.equipa = equipa.clone();
        dropdowns = new ArrayList<>(11);
        substituicoes = new HashMap<>();
    }

    public void setOnGravar(ICallbackTres<Map<Integer, Integer>, List<Integer>, ModeloTatico> onGravar) {
        this.onGravar = onGravar;
    }

    public void mostra() throws IOException {
        popUp.setScene(new Scene(loader.load()));

        modeloTatico.getItems().add(new ModeloTatico(4,4,2));
        modeloTatico.getItems().add(new ModeloTatico(4,3,4));
        modeloTatico.getItems().add(new ModeloTatico(3,5,2));
        modeloTatico.setValue(new ModeloTatico(4,4,2));

        substituirPor.getItems().setAll(equipa.getJogadores());
        aSubstituir.getItems().setAll(equipa.getJogadores());

        atualizaDropdowns();
        layoutSubstituicoes();

        if (setup != null) {
            modeloTatico.setValue(setup.getModeloTatico());
            atualizaDropdowns();
            for (int i = 0; i < 11; i++) {
                dropdowns.get(i).setValue(equipa.getJogador(setup.getTitulares().get(i)));
            }
        }

        popUp.show();
    }

    @FXML
    private void atualizaDropdowns() {
        grelha.getChildren().clear();
        dropdowns.clear();
        ModeloTatico modeloTatico = this.modeloTatico.getValue();

        for (int i = 0; i < 4; i++) {
            Label n = new Label();
            n.setFont(new Font("System Bold", 13.0));
            GridPane.setHalignment(n, HPos.CENTER);
            PosicaoJogador posicao = PosicaoJogador.GUARDA_REDES;
            int nDropdowns = 0;
            switch (i) {
                case 0:
                    n.setText("Guarda Redes");
                    posicao = PosicaoJogador.GUARDA_REDES;
                    nDropdowns  = 1;
                    break;
                case 1:
                    n.setText("Defesas");
                    posicao = PosicaoJogador.DEFESA;
                    nDropdowns  = modeloTatico.getNumDefesas();
                    break;
                case 2:
                    n.setText("Médios");
                    posicao = PosicaoJogador.MEDIO;
                    nDropdowns  = modeloTatico.getNumMedios();
                    break;
                case 3:
                    n.setText("Avançados");
                    posicao = PosicaoJogador.AVANCADO;
                    nDropdowns  = modeloTatico.getNumAvancados();
                    break;
            }
            grelha.add(n, i, 0);

            for (int j = 0; j < nDropdowns ; j++) {
                ChoiceBox<Jogador> box = new ChoiceBox<>();
                box.setPrefWidth(150.0);
                PosicaoJogador finalPosicao = posicao;
                box.getItems().setAll(this.equipa.getJogadores().stream()
                        .sorted(Comparator.comparingDouble(a -> -a.getAdequacao(finalPosicao)))
                        .collect(Collectors.toList()));
                // para que o compilador não reclame que a variável não é final
                box.setConverter(new StringConverter<Jogador>() {
                    @Override
                    public String toString(Jogador jogador) {
                        return jogador.getNomeJogador() + " | " +
                                NumberFormat.getInstance().format(jogador.getAdequacao(finalPosicao));
                    }

                    @Override
                    public Jogador fromString(String string) {
                        return null;
                    }
                });
                grelha.add(box, i, j + 1);
                dropdowns.add(box);
                GridPane.setHgrow(box, Priority.ALWAYS);
            }
        }
    }

    @FXML
    private void addSubstituicao() {
        if (aSubstituir.getValue() == substituirPor.getValue() || aSubstituir.getValue() == null || substituirPor.getValue() == null
                || substituicoes.containsKey(aSubstituir.getValue().getNumeroJogador())
                || substituicoes.containsValue(substituirPor.getValue().getNumeroJogador())) {
            Alert e = new Alert(Alert.AlertType.ERROR);
            e.setTitle("Jogadores inválidos");
            e.setHeaderText("Esta substituição é inválida");
            e.show();
        } else {
            substituicoes.put(aSubstituir.getValue().getNumeroJogador(), substituirPor.getValue().getNumeroJogador());
            layoutSubstituicoes();
            aSubstituir.setValue(null);
            substituirPor.setValue(null);
        }
    }

    private void layoutSubstituicoes() {
        tabelaSubstituicoes.getChildren().clear();

        int row = 0;
        for (Map.Entry<Integer, Integer> sub : substituicoes.entrySet()) {
            Label la = new Label();
            la.setText(equipa.getJogador(sub.getKey()).getNomeJogador());
            Label lb = new Label();
            lb.setText(equipa.getJogador(sub.getValue()).getNomeJogador());
            Button delete = new Button();
            delete.setText("Apagar");
            delete.setOnAction(v -> {
                substituicoes.remove(sub.getKey());
                layoutSubstituicoes();
            });
            delete.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(delete, Priority.ALWAYS);
            HBox buttonBox = new HBox(delete);

            tabelaSubstituicoes.add(la, 0, row);
            tabelaSubstituicoes.add(lb, 1, row);
            tabelaSubstituicoes.add(buttonBox, 2, row);
            row++;
        }
    }

    @FXML
    private void gravar() {
        if (this.onGravar != null) {
            List<Integer> emCampo = new ArrayList<>();

            for (ChoiceBox<Jogador> box : dropdowns) {
                if (box.getValue() != null)
                    emCampo.add(box.getValue().getNumeroJogador());
            }

            onGravar.run(new HashMap<>(substituicoes), emCampo, modeloTatico.getValue().clone());
        }
    }

    @FXML
    private void cancelar() {
        fecha();
    }

    public void fecha() {
        popUp.close();
    }

    public void setSetup(SetupEquipa setup) {
        this.setup = setup;
    }

    public void setSubstituicoes(Map<Integer, Integer> substituicoes) {
        this.substituicoes = substituicoes;
    }
}
