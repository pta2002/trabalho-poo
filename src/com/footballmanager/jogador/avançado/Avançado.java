package com.footballmanager.jogador.avançado;

import com.footballmanager.jogador.Jogador;

public abstract class Avançado extends Jogador {
    private double desmarcacao;
    public Avançado(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double desmarcacao) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.desmarcacao = desmarcacao;
    }

    @Override
    abstract public double getHabilidade() {
        return 0;
    }

    public double getDesmarcacaoa(){
        return this.desmarcacao;
    }

    public void setDesmarcacao(double desmarcacao){
        this.desmarcacao = desmarcacao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Avançado avançado = (Avançado) object;
        return java.lang.Double.compare(avançado.desmarcacao, desmarcacao) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), desmarcacao);
    }

    public Avançado clone() {
        return new Avançado(this);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Avançado{" +
                "desmarcacao=" + desmarcacao +
                '}';
    }
}
