package com.footballmanager.jogador;

public class Médio extends  Jogador{
    public Médio(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
    }
    @Override
    public double getHabilidade() {
        return 0;
    }
}
