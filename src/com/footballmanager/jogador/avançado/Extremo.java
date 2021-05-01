package com.footballmanager.jogador.avançado;

public class Extremo extends Avançado {

    public Extremo(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double desmarcacao) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade, desmarcacao);
    }

    @Override
    public double getHabilidade() {
        return 0;
    }


}
