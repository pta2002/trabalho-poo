package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Defesa extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    /* TODO */

    /* ---------------------------------------------------------- Construtores */
    public Defesa(){
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

    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, List<String> e) {
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

    public Defesa(Defesa defesa){
        this.nomeJogador = defesa.getNomeJogador();
        this.numeroJogador = defesa.getNumeroJogador();
        this.velocidade = defesa.getVelocidade();
        this.resistencia = defesa.getResistencia();
        this.destreza = defesa.getDestreza();
        this.impulsao = defesa.getImpulsao();
        this.cabeca = defesa.getCabeca();
        this.remate = defesa.getRemate();
        this.passe = defesa.getPasse();
        this.historialEquipas = defesa.getHistorialEquipas();
    }

    /* ----------------------------------------------------------- Parsing */
    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
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
    public Defesa clone(){
        return new Defesa(this);
    }

    /* ----------------------------------------------------------- Habilidade */
    @Override
    public double getHabilidade() {
        double soma = this.getRemate() + this.getVelocidade() + this.getCabeca()*3 +
                this.getDestreza() + this.getPasse()*2 + this.getImpulsao()*3 + this.getResistencia()*2;

        return soma / 13;
    }

    public double getAdequacao(PosicaoJogador posicao) {
        double defesaParaDefesaConst = 1;
        double defesaParaMedioConst = 0.8;
        double defesaParaGuardaRedesConst = 0.1;
        double defesaParaAvancadoConst = 0.5;
        double adequacao = 0;

        switch (posicao) {
            case GUARDA_REDES:
                adequacao = (((double) impulsao + destreza)/(2*100))*defesaParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = defesaParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) passe + velocidade + resistencia + destreza)/(4*100))*defesaParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) velocidade + impulsao + remate + cabeca + destreza)/(5*100))*defesaParaAvancadoConst;
                break;
        }

        return adequacao;
    }
}