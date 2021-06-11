package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Medio extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int recuperacao;

    /* ----------------------------------------------------------- Construtores */
    public Medio(){
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

        recuperacao = 50;
    }

    public Medio(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec, List<String> e) {
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

        recuperacao = rec;
    }

    public Medio(Medio medio){
        super.nomeJogador = medio.getNomeJogador();
        super.numeroJogador = medio.getNumeroJogador();
        super.velocidade = medio.getVelocidade();
        super.resistencia = medio.getResistencia();
        super.destreza = medio.getDestreza();
        super.impulsao = medio.getImpulsao();
        super.cabeca = medio.getCabeca();
        super.remate = medio.getRemate();
        super.passe = medio.getPasse();
        this.historialEquipas = medio.getHistorialEquipas();

        this.recuperacao = medio.getRecuperacao();
    }

    /* ----------------------------------------------------------- Getter's e Setter's */
    public int getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(int recuperacao) {
        this.recuperacao = recuperacao;
    }

    /* ----------------------------------------------------------- Parsing */
    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                new ArrayList<>());
    }

    /* ----------------------------------------------------------- Clone */
    public Medio clone(){
        return new Medio(this);
    }

    /* ----------------------------------------------------------- Habilidade */
    @Override
    public double getHabilidade() {
        double soma = this.getRemate()*2 + this.getVelocidade()*2 + this.getCabeca()* + this.getRecuperacao()*2 +
                this.getDestreza()*2 + this.getPasse()*4 + this.getImpulsao() + this.getResistencia();

        return soma / 15;
    }

    public double getAdequacao(PosicaoJogador posicao) {
        double medioParaDefesaConst = 0.6;
        double medioParaMedioConst = 1;
        double medioParaGuardaRedesConst = 0.1;
        double medioParaAvancadoConst = 0.8;
        double adequacao = 0;

        switch (posicao) {
            case GUARDA_REDES:
                adequacao = (((double) impulsao + destreza) / (2 * 100)) * medioParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = ((double) (cabeca + impulsao + passe) / (3 * 100)) * medioParaDefesaConst;
                break;
            case MEDIO:
                adequacao = medioParaMedioConst;
                break;
            case AVANCADO:
                adequacao = ((double) (velocidade + impulsao + remate + cabeca + destreza) / (5 * 100)) * medioParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}