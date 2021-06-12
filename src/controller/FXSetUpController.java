package controller;

import controller.interfaces.ICallbackDois;
import javafx.scene.control.Alert;
import model.Equipa.Equipa;
import model.Equipa.SetupEquipa;
import model.Exceptions.JogadoresInvalidosException;
import model.Exceptions.SubstituicaoInvalidaException;
import model.FootballManagerModel;
import model.Jogo.ModeloTatico;
import view.FXSetUpView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FXSetUpController {
    private FootballManagerModel model;
    private FXSetUpView view;
    private Equipa equipa;

    private ICallbackDois<Map<Integer, Integer>, SetupEquipa> onGravar;

    public FXSetUpController(Equipa e, FootballManagerModel model, FXSetUpView view) {
        this.model = model;
        this.view = view;
        this.view.setOnGravar(this::gravar);
        this.equipa = e.clone();
    }

    public void setOnGravar(ICallbackDois<Map<Integer, Integer>, SetupEquipa> onGravar) {
        this.onGravar = onGravar;
    }

    private void gravar(Map<Integer, Integer> substituicoes, List<Integer> jogadores, ModeloTatico modeloTatico) {
        List<Integer> noBanco = new ArrayList<>();

        try {
            if (jogadores.size() != 11) {
                throw new JogadoresInvalidosException("A equipa tem de ter 11 jogadores");
            }

            if (new HashSet<Integer>(jogadores).size() != 11) {
                throw new JogadoresInvalidosException("A equipa tem jogadores repetidos");
            }

            for (Map.Entry<Integer, Integer> sub : substituicoes.entrySet()) {
                noBanco.add(sub.getValue());
                if (!jogadores.contains(sub.getValue())) {
                    throw new SubstituicaoInvalidaException("Jogador a substituir não está em campo");
                }
            }

            SetupEquipa s = new SetupEquipa(equipa, modeloTatico, jogadores, noBanco);

            if (onGravar != null) {
                onGravar.run(substituicoes, s);
                this.view.fecha();
            }
        } catch (Exception e) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Set up inválido");
            erro.setContentText(e.getMessage());
            erro.show();
        }
    }

    public void mostraPopup() throws IOException {
        this.view.mostra();
    }

    public void setSetup(SetupEquipa setup) {
        if (setup != null)
            this.view.setSetup(setup);
    }

    public void setSubstituicoes(Map<Integer, Integer> substituicoes) {
        if (substituicoes != null)
            this.view.setSubstituicoes(substituicoes);
    }
}
