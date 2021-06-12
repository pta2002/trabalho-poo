package model.Jogo.Evento;

import model.Jogador.Jogador;

/***
 * Representa um evento de passagem de bola ao longo do jogo.
 * Isto representa qualquer evento em que a bola passa de um jogador a outro, quer seja dentro da mesma equipa ou não.
 */
public class PassagemBola extends EventoJogo {
    private int jogadorAntes;
    private String equipaAntes;
    private int jogadorDepois;
    private String equipaDepois;

    public PassagemBola(double tempo, String equipaAntes, int jogadorAntes, String equipaDepois, int jogadorDepois) {
        super(tempo);
        this.equipaAntes = equipaAntes;
        this.jogadorAntes = jogadorAntes;
        this.equipaDepois = equipaDepois;
        this.jogadorDepois = jogadorDepois;
    }

    public int getJogadorAntes() {
        return jogadorAntes;
    }

    public void setJogadorAntes(int jogadorAntes) {
        this.jogadorAntes = jogadorAntes;
    }

    public String getEquipaAntes() {
        return equipaAntes;
    }

    public void setEquipaAntes(String equipaAntes) {
        this.equipaAntes = equipaAntes;
    }

    public int getJogadorDepois() {
        return jogadorDepois;
    }

    public void setJogadorDepois(int jogadorDepois) {
        this.jogadorDepois = jogadorDepois;
    }

    public String getEquipaDepois() {
        return equipaDepois;
    }

    public void setEquipaDepois(String equipaDepois) {
        this.equipaDepois = equipaDepois;
    }

    public String toString() {
        return "Passagem: " + equipaAntes + " " + jogadorAntes + " -> " + equipaDepois + " " + jogadorDepois;
    }

    public PassagemBola clone() {
        return new PassagemBola(getTempo(), equipaAntes, jogadorAntes, equipaAntes, jogadorDepois);
    }
}
