package com.footballmanager.jogador.defesa;

public class DefesaLateral extends Defesa{
    private double cruzamento;

    public DefesaLateral(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade,double cruzamento) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.cruzamento = cruzamento;
    }
}