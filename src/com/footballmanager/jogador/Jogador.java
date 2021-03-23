package com.footballmanager.jogador;

import java.util.Objects;

public class Jogador {
    private String nome;

    private double velocidade;
    private double resistencia;
    private double destreza;
    private double impulsao;
    private double jogoDeCabeca;
    private double remate;
    private double capacidadeDePasse;
    private double habilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public double getDestreza() {
        return destreza;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public double getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(double impulsao) {
        this.impulsao = impulsao;
    }

    public double getJogoDeCabeca() {
        return jogoDeCabeca;
    }

    public void setJogoDeCabeca(double jogoDeCabeca) {
        this.jogoDeCabeca = jogoDeCabeca;
    }

    public double getRemate() {
        return remate;
    }

    public void setRemate(double remate) {
        this.remate = remate;
    }

    public double getCapacidadeDePasse() {
        return capacidadeDePasse;
    }

    public void setCapacidadeDePasse(double capacidadeDePasse) {
        this.capacidadeDePasse = capacidadeDePasse;
    }

    public double getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(double habilidade) {
        this.habilidade = habilidade;
    }

    public Jogador(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoDeCabeca = jogoDeCabeca;
        this.remate = remate;
        this.capacidadeDePasse = capacidadeDePasse;
        this.habilidade = habilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador)) return false;
        Jogador jogador = (Jogador) o;
        return Double.compare(jogador.getVelocidade(), getVelocidade()) == 0 && Double.compare(jogador.getResistencia(), getResistencia()) == 0 && Double.compare(jogador.getDestreza(), getDestreza()) == 0 && Double.compare(jogador.getImpulsao(), getImpulsao()) == 0 && Double.compare(jogador.getJogoDeCabeca(), getJogoDeCabeca()) == 0 && Double.compare(jogador.getRemate(), getRemate()) == 0 && Double.compare(jogador.getCapacidadeDePasse(), getCapacidadeDePasse()) == 0 && Double.compare(jogador.getHabilidade(), getHabilidade()) == 0 && getNome().equals(jogador.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getVelocidade(), getResistencia(), getDestreza(), getImpulsao(), getJogoDeCabeca(), getRemate(), getCapacidadeDePasse(), getHabilidade());
    }
}