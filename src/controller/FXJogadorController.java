package controller;

import controller.interfaces.ICallbackZero;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import model.Equipa.Equipa;
import model.Exceptions.EquipaNaoExisteException;
import model.Exceptions.JogadorNaoEstaPresenteException;
import model.Exceptions.NumeroJaOcupadoException;
import model.FootballManagerModel;
import model.Jogador.Jogador;
import view.FXJogadorView;

import java.io.IOException;

public class FXJogadorController {
    private FootballManagerModel model;
    private FXJogadorView view;
    private String equipa;
    private ICallbackZero onGravar;
    private Jogador jogador;

    public FXJogadorController(FootballManagerModel model, FXJogadorView view, String equipa) {
        this.model = model;
        this.view = view;
        this.equipa = equipa;
        this.view.setOnGravar(this::gravar);

        this.view.setOnTransferir(this::transferir);
    }

    private void transferir(int numJogador) {
        ChoiceDialog<Equipa> equipaDialog = new ChoiceDialog<>();
        equipaDialog.setHeaderText("Escolha uma equipa");
        equipaDialog.setTitle("Transferência de jogador");
        equipaDialog.getItems().setAll(model.getEquipas().values());

        Equipa equipa = equipaDialog.showAndWait().orElse(null);
        if (equipa != null) {
            try {
                model.transfereJogador(jogador.getNumeroJogador(), numJogador, this.equipa, equipa.getNome());
                this.onGravar.run();
                this.view.fecha();
            } catch (EquipaNaoExisteException | JogadorNaoEstaPresenteException e) {
                e.printStackTrace();
            } catch (NumeroJaOcupadoException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao transferir jogador");
                alert.setHeaderText("Já existe um jogador com esse número na equipa de destino");
                alert.show();
            }
        }
    }

    public void setOnGravar(ICallbackZero onGravar) {
        this.onGravar = onGravar;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public void mostrarPopup() throws IOException {
        this.view.mostra();
    }

    private void gravar(Jogador j) {
        if (model.getEquipa(equipa).getJogador(j.getNumeroJogador()) != null && (jogador == null || jogador.getNumeroJogador() != j.getNumeroJogador())) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Jogador já existe");
            err.setHeaderText("Já existe um jogador com este número");
            err.show();
        } else {
            if (jogador != null) {
                model.getEquipa(equipa).removeJogador(jogador);
            }
            model.insereJogador(j, equipa);
            this.onGravar.run();
            view.fecha();
        }
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        this.view.setJogador(jogador);
    }
}
