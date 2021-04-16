package com.footballmanager.jogador.avançado;

public class PontaLança extends Avançado{
    private double protecaoBola;
    public PontaLança(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double desmarcacao, double protecaoBola) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade, desmarcacao);
        this.protecaoBola = protecaoBola;
    }
}
