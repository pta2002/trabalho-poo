package com.footballmanager.jogador.avançado;

import com.footballmanager.jogador.Jogador;

public class Avançado extends Jogador {
    private double desmarcacao;
    public Avançado(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double desmarcacao) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade);
        this.desmarcacao = desmarcacao;
    }
    @Override
    public double getHabilidade() {
        return 0;
    }
}
