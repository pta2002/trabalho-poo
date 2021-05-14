package model;

import model.Equipa.Equipa;
import model.Jogador.Jogador;
import model.Jogo.Jogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballManagerModel {
    /* ----------------------------------------------------------- Atributos */
    Map<String, Equipa> equipas;
    List<Jogo> jogos;

    /* ---------------------------------------------------------- Construtores */
    /***
     * Construtor vazio
     */
    public FootballManagerModel() {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    /***
     * Construtor parametrizado
     * @param equipas equipas
     * @param jogos jogos
     */
    public FootballManagerModel(Map<String, Equipa> equipas, List<Jogo> jogos) {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();

        for(Map.Entry<String, Equipa> entry : equipas.entrySet()) {
            equipas.put(entry.getKey(), entry.getValue().clone());
        }

        for(Jogo jogo: jogos) {
            jogos.add(jogo);
        }
    }

    /***
     * Construtor de cópia
     * @param FMModel model
     */
    public FootballManagerModel(FootballManagerModel FMModel) {
        this.equipas = FMModel.getEquipas();
        this.jogos = FMModel.getJogos();
    }

    /* --------------------------------------------------------- Getter's e Setter's */
    public Map<String, Equipa> getEquipas() {
        Map<String,Equipa> equipas = new HashMap<>();

        for(Map.Entry<String, Equipa> entry : this.equipas.entrySet()) {
            equipas.put(entry.getKey(), entry.getValue().clone());
        }

        return equipas;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        Map<String,Equipa> copiaEquipas = new HashMap<>();

        for(Map.Entry<String, Equipa> entry : equipas.entrySet()) {
            copiaEquipas.put(entry.getKey(), entry.getValue().clone());
        }

        this.equipas = copiaEquipas;
    }

    /* TODO: encapsular com clone */
    public List<Jogo> getJogos() {
        List<Jogo> jogos = new ArrayList<>();

        for(Jogo jogo: this.jogos) {
            jogos.add(jogo);
        }

        return jogos;
    }

    /* TODO: encapsular com clone*/
    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    /* ---------------------------------------------------------- Retorna a equipa indicada pela key*/
    public Equipa getEquipa(String equipa) {
         return this.equipas.get(equipa);
    }

    /* ---------------------------------------------------------- Insere Jogador numa equipa*/
    public void insereJogador(Jogador jog, String equipa) {
        Equipa value = this.equipas.get(equipa);
        value.insereJogador(jog);
        this.equipas.replace(equipa,value);
    }

    /* ---------------------------------------------------------- Verifica se uma equipa existe */
    public Boolean existeEquipa(String equipa ) {
      return this.equipas.containsKey(equipa);
    }
}
