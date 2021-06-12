package controller;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.FootballManagerModel;
import view.FXJogadoresView;
import view.JogadorView;

import java.io.IOException;

public class FXJogadoresController {
    private FootballManagerModel model;
    private FXJogadoresView view;
    private String equipa;

    public FXJogadoresController(FootballManagerModel model, FXJogadoresView view) {
        this.model = model;
        this.view = view;

        this.view.setCallback(v -> {
            if (this.equipa != null) {
                JogadorView jv = new JogadorView();
                JogadorController jc = new JogadorController(model, jv, this.equipa);
                jc.setOnGravar(() -> this.setEquipa(equipa));
                try {
                    jc.mostrarPopup();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
        this.view.setJogadores(model.getEquipa(equipa).getJogadores());
    }
}
