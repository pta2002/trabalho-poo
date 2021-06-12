package controller;

import javafx.scene.control.Alert;
import model.FootballManagerModel;
import model.Jogo.Evento.EventoJogo;
import model.Jogo.Jogo;
import model.Jogo.SetupEquipa;
import view.FXSetUpView;
import view.FXSimulacaoView;

import java.io.IOException;
import java.time.LocalDate;
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

        this.view.setOnConfigFora(equipa -> {
            FXSetUpView sv = new FXSetUpView(this.model.getEquipa(equipa));
            FXSetUpController sc = new FXSetUpController(this.model.getEquipa(equipa), this.model, sv);
            sc.setSetup(setupFora);
            sc.setSubstituicoes(substituicoesFora);
            sc.setOnGravar((substituicoes, setup) -> {
                substituicoesFora = new HashMap<>(substituicoes);
                setupFora = setup.clone();
            });
            try {
                sc.mostraPopup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        this.view.setOnSimular(this::simular);
    }

    private void simular() {
        if (view.getAleatorioCasa()) {
            setupCasa = new SetupEquipa(model.getEquipa(view.getEquipaCasa()));
        }

        if (view.getAleatorioFora()) {
            setupFora = new SetupEquipa(model.getEquipa(view.getEquipaFora()));
        }

        if (view.getEquipaCasa().equals(view.getEquipaFora()) || view.getEquipaFora() == null || view.getEquipaCasa() == null) {
            Alert e = new Alert(Alert.AlertType.ERROR);
            e.setTitle("Erro ao criar simulação");
            e.setHeaderText("As equipas têm de ser duas equipas diferentes");
            e.show();
        } else if (setupCasa == null || setupFora == null
                || !setupCasa.getEquipa().getNome().equals(view.getEquipaCasa()) || !setupFora.getEquipa().getNome().equals(view.getEquipaFora())) {
            Alert e = new Alert(Alert.AlertType.ERROR);
            e.setTitle("Erro ao criar simulação");
            e.setHeaderText("Ambas as equipas têm de estar configuradas");
            e.show();
        } else {
            if (substituicoesCasa == null)
                substituicoesCasa = new HashMap<>();
            if (substituicoesFora == null)
                substituicoesFora = new HashMap<>();
            Jogo j = new Jogo(view.getEquipaCasa(), view.getEquipaFora(), LocalDate.now(), setupCasa, setupFora, substituicoesCasa, substituicoesFora);
            System.out.println("Avançou simulação");
            EventoJogo evento;
            view.clearEventos();
            while ((evento = j.avancaSimulacao(model)) != null) {
                view.addEvento(evento);
            }
            Alert pontuacao = new Alert(Alert.AlertType.INFORMATION);
            pontuacao.setTitle("Resultados do jogo");
            pontuacao.setHeaderText("Jogo acabou em " + j.getGolosCasa() + "-" + j.getGolosFora());
            pontuacao.show();
            model.addJogo(j.clone());
        }
    }

    public void mostrarPopup() throws IOException {
        this.view.mostra();
    }
}
