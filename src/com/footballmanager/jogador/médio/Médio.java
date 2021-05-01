package com.footballmanager.jogador.médio;

import com.footballmanager.jogador.Jogador;

public abstract class Médio extends Jogador {
    private double posicionamento;
    public Médio(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
    }
    @Override
    abstract  public double getHabilidade() {
        return 0;
    }

    public double getPosicionamento() {
        return posicionamento;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Médio médio = (Médio) object;
        return java.lang.Double.compare(médio.getPosicionamento(), getPosicionamento()) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getPosicionamento());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Médio{" +
                "posicionamento=" + posicionamento +
                '}';
    }

    public void setPosicionamento(double posicionamento) {
        this.posicionamento = posicionamento;
    }
}
