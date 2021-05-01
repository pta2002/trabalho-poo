package com.footballmanager.jogador.médio;

public class MédioOfensivo extends Médio{
    private double criacaoJogada;
    public MédioOfensivo(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double criacaoJogada) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.criacaoJoagada = criacaoJogada;
    }

    public double getCriacaoJogada(){
        return this.criacaoJogada;
    }

    public void setCriacaoJogada(double criacaoJogada){
        this.criacaoJogada = criacaoJogada;
    }

    @java.lang.Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        MédioOfensivo that = (MédioOfensivo) object;
        return java.lang.Double.compare(that.getCriacaoJogada(), getCriacaoJogada()) == 0;
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getCriacaoJogada());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "MédioOfensivo{" +
                "criacaoJogada=" + criacaoJogada +
                '}';
    }

    @Override
    public double getHabilidade() {return 0;}

}
