package controller;

import model.Equipa.SetupEquipa;
import model.FootballManagerModel;
import view.FXSetUpView;
import view.FXSimulacaoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FXSimulacaoController {
    private FootballManagerModel model;
    private FXSimulacaoView view;

    private SetupEquipa setupCasa;
    private SetupEquipa setupFora;

    private Map<Integer, Integer> substituicoesCasa;
    private Map<Integer, Integer> substituicoesFora;

    public FXSimulacaoController(FootballManagerModel model, FXSimulacaoView view) {
        this.model = model;
        this.view = view;
        this.view.setEquipas(new ArrayList<>(model.getEquipas().keySet()));

        this.view.setOnConfigCasa(equipa -> {
            FXSetUpView sv = new FXSetUpView(this.model.getEquipa(equipa));
            FXSetUpController sc = new FXSetUpController(this.model.getEquipa(equipa), this.model, sv);
            sc.setSetup(setupCasa);
            sc.setSubstituicoes(substituicoesCasa);
            sc.setOnGravar((substituicoes, setup) -> {
                substituicoesCasa = new HashMap<>(substituicoes);
                setupCasa = setup.clone();
            });
            try {
                sc.mostraPopup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void mostrarPopup() throws IOException {
        this.view.mostra();
    }
}
