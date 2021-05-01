package com.footballmanager.jogador.guardaRedes;

import com.footballmanager.jogador.Jogador;

public class GuardaRedes extends Jogador {
    private double elasticidade;
    public GuardaRedes(String nome, double velocidade, double resistencia, double destreza, double impulsao,
                       double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade,double elasticidade) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.elasticidade = elasticidade;
    }

    @Override
    public double getHabilidade() {
        return 0;
    }

    public double getElasticidade(){
        return this.elasticidade;
    }

    public void setElasticidade(double elasticidade){
        this.elasticidade = elasticidade;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GuardaRedes that = (GuardaRedes) object;
        return java.lang.Double.compare(that.getElasticidade(), getElasticidade()) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getElasticidade());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GuardaRedes{" +
                "elasticidade=" + elasticidade +
                '}';
    }
}
