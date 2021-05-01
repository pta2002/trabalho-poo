package com.footballmanager.jogador.médio;

public class MédioDefensivo extends Médio{
    private double recuperacaoBola;
    public MédioDefensivo(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double recuperacaoBola) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.recuperacaoBola = recuperacaoBola;
    }

    public double getRecuperacaoBola(){
        return this.recuperacaoBola;
    }

    public void setRecuperacaoBola(double recuperacao){
        this.recuperacaoBola = recuperacao;
    }

    @java.lang.Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        MédioDefensivo that = (MédioDefensivo) object;
        return java.lang.Double.compare(that.getRecuperacaoBola(), getRecuperacaoBola()) == 0;
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getRecuperacaoBola());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "MédioDefensivo{" +
                "recuperacaoBola=" + recuperacaoBola +
                '}';
    }

    @Override
    public double getHabilidade() {return 0;}
}
