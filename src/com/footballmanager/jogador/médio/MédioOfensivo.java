package com.footballmanager.jogador.médio;

public class MédioOfensivo extends Médio{
    private double criacaoJoagada;
    public MédioOfensivo(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double criacaoJogada) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.criacaoJoagada = criacaoJogada;
    }
}
