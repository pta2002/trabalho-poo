package com.footballmanager.jogador.médio;

public class MédioDefensivo extends Médio{
    private double recuperacaoBola;
    public MédioDefensivo(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double recuperacaoBola) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.recuperacaoBola = recuperacaoBola;
    }
}
