package com.footballmanager.jogador.defesa;

import com.footballmanager.jogador.Jogador;

public abstract class Defesa extends Jogador {
    
    public Defesa(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
    }

    @Override
    abstract public double getHabilidade() ;
}
