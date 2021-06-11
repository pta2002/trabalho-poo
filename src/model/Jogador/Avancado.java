package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Avancado extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    /* TODO */

    /* ----------------------------------------------------------- Construtores */
    public Avancado(){
        this.nomeJogador = "unknown";
        this.numeroJogador = 0;
        this.velocidade = 50;
        this.resistencia = 50;
        this.destreza = 50;
        this.impulsao = 50;
        this.cabeca = 50;
        this.remate = 50;
        this.passe = 50;
        this.historialEquipas = new ArrayList<>();
    }

    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, List<String> e) {
        this.nomeJogador = nomeJ;
        this.numeroJogador = numeroJ;
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.cabeca = cab;
        this.remate = rem;
        this.passe = p;
        this.historialEquipas = new ArrayList<>(e);
    }

    public Avancado(Avancado avancado){
        this.nomeJogador = avancado.getNomeJogador();
        this.numeroJogador = avancado.getNumeroJogador();
        this.velocidade = avancado.getVelocidade();
        this.resistencia = avancado.getResistencia();
        this.destreza = avancado.getDestreza();
        this.impulsao = avancado.getImpulsao();
        this.cabeca = avancado.getCabeca();
        this.remate = avancado.getRemate();
        this.passe = avancado.getPasse();
        this.historialEquipas = avancado.getHistorialEquipas();
    }

    /* ----------------------------------------------------------- Parsing */
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                new ArrayList<>());
    }

    /* ----------------------------------------------------------- Clone */
    public Avancado clone(){
        return new Avancado(this);
    }

    /* ----------------------------------------------------------- Habilidade */
    @Override
    public double getHabilidade() {
        double soma = this.getRemate()*4 + this.getVelocidade()*3 + this.getCabeca()*3 +
                     this.getDestreza()*2 + this.getPasse() + this.getImpulsao()*2 + this.getResistencia();

        return soma / 14;
    }

    @Override
    public double getAdequacao(PosicaoJogador posicao) {
        double avancadoParaDefesaConst = 0.5;
        double avancadoParaMedioConst = 0.8;
        double avancadoParaGuardaRedesConst = 0.1;
        double avancadoParaAvancadoConst = 1;
        double adequacao = 0;

        switch (posicao) {
            case GUARDA_REDES:
                adequacao = (((double) impulsao + destreza) / (2 * 100)) * avancadoParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = (((double) cabeca + impulsao + passe) / (3 * 100)) * avancadoParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) passe + velocidade + resistencia + destreza) / (4 * 100)) * avancadoParaMedioConst;
                break;
            case AVANCADO:
                adequacao = avancadoParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}