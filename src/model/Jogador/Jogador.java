package model.Jogador;

import model.Jogo.PosicaoJogador;

public abstract class Jogador {

    /* ----------------------------------------------------------- Atributos */
    protected String nomeJogador;
    protected int numeroJogador;
    protected int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;

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
