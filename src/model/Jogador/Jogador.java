package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Jogador implements Serializable {

    /* ----------------------------------------------------------- Atributos */
    private String nomeJogador;
    private int numeroJogador;
    private int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;
    private List<String> historialEquipas;
    private static final long serialVersionUID = 4L;

    public Jogador(String nomeJogador, int numeroJogador, int velocidade, int resistencia, int destreza, int impulsao, int cabeca, int remate, int passe, List<String> historialEquipas) {
        this.nomeJogador = nomeJogador;
        this.numeroJogador = numeroJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeca = cabeca;
        this.remate = remate;
        this.passe = passe;
        this.historialEquipas = new ArrayList<String>(historialEquipas);
    }

    public Jogador(Jogador jog) {
        this.nomeJogador = jog.nomeJogador;
        this.numeroJogador = jog.numeroJogador;
        this.velocidade = jog.velocidade;
        this.resistencia = jog.resistencia;
        this.destreza = jog.destreza;
        this.impulsao = jog.impulsao;
        this.cabeca = jog.cabeca;
        this.remate = jog.remate;
        this.passe = jog.passe;
        this.historialEquipas = new ArrayList<String>(jog.historialEquipas);
    }

    /* ----------------------------------------------------------- Getter's e Setter's */
    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeca(int cabeca) {
        this.cabeca = cabeca;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public List<String> getHistorialEquipas() {
        return new ArrayList<>(historialEquipas);
    }

    public void setHistorialEquipas(List<String> equipas) {
        this.historialEquipas = new ArrayList<>(equipas);
    }

    public void addEquipa(String equipa) {
        this.historialEquipas.add(equipa);
    }

    public abstract double getHabilidade();

    public abstract double getAdequacao(PosicaoJogador posicao);

    /* ----------------------------------------------------------- Clone */
    @Override
    abstract public Jogador clone();

    /* ----------------------------------------------------------- toString */
    @Override
    public String toString(){
        return nomeJogador + " -> Overall: " + this.getHabilidade() + "\n";
    }

    /* ----------------------------------------------------------- Equals */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Jogador outroJogador = (Jogador) obj;
        return (this.numeroJogador == outroJogador.numeroJogador);
    }

}
