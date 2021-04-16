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
}
