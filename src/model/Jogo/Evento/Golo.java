package model.Jogo.Evento;

import model.Equipa.Equipa;
import model.Jogador.Jogador;

/***
 * Representa um golo no jogo
 */
public class Golo extends EventoJogo {
    private String equipaMarcou;
    private int jogadorMarcou;
    private String equipaSofreu;

    public Golo(double tempo, String equipaMarcou, int jogadorMarcou, String equipaSofreu) {
        super(tempo);
        this.equipaMarcou = equipaMarcou;
        this.jogadorMarcou = jogadorMarcou;
        this.equipaSofreu = equipaSofreu;
    }

    public String getEquipaMarcou() {
        return equipaMarcou;
    }

    public void setEquipaMarcou(String equipaMarcou) {
        this.equipaMarcou = equipaMarcou;
    }

    public int getJogadorMarcou() {
        return jogadorMarcou;
    }

    public void setJogadorMarcou(int jogadorMarcou) {
        this.jogadorMarcou = jogadorMarcou;
    }

    public String getEquipaSofreu() {
        return equipaSofreu;
    }

    public void setEquipaSofreu(String equipaSofreu) {
        this.equipaSofreu = equipaSofreu;
    }

    public String toString() {
        return "Golo marcado por: " + equipaMarcou + " " + jogadorMarcou + " -> " + equipaSofreu;
    }
}
