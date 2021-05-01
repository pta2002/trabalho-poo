package com.footballmanager.jogador.defesa;

public class DefesaLateral extends Defesa{
    private double cruzamento;

    public DefesaLateral(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade,double cruzamento) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.cruzamento = cruzamento;
    }

    public double getCruzamento(){
        return this.cruzamento;
    }

    public void setCruzamento(double cruzamento){
        this.cruzamento = cruzamento;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DefesaLateral that = (DefesaLateral) object;
        return java.lang.Double.compare(that.getCruzamento(), getCruzamento()) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getCruzamento());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DefesaLateral{" +
                "cruzamento=" + cruzamento +
                '}';
    }

    @Override
    public double getHabilidade() {return 0;}
}