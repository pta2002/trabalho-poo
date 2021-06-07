package controller;

import model.FootballManagerModel;

import java.util.ArrayList;
import java.util.Arrays;

public class SimulacaoController extends Menu {
    public SimulacaoController() {
        super.opcoes = new ArrayList<>();
        super.op = 0;
    }

    public SimulacaoController(String[] opcoes) {
        super.opcoes = Arrays.asList(opcoes);
        super.op = 0;
    }

    @Override
    public void executa(FootballManagerModel model) {

    }
}
