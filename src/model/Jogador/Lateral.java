package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Lateral extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int cruzamento;

    /* ----------------------------------------------------------- Construtores */
    public Lateral(){
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

        this.cruzamento = 50;
    }

    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz, List<String> e) {
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

        this.cruzamento = cruz;
    }

    public Lateral(Lateral lateral){
        this.nomeJogador = lateral.getNomeJogador();
        this.numeroJogador = lateral.getNumeroJogador();
        this.velocidade = lateral.getVelocidade();
        this.resistencia = lateral.getResistencia();
        this.destreza = lateral.getDestreza();
        this.impulsao = lateral.getImpulsao();
        this.cabeca = lateral.getCabeca();
        this.remate = lateral.getRemate();
        this.passe = lateral.getPasse();
        this.historialEquipas = lateral.getHistorialEquipas();
    }

    /* ----------------------------------------------------------- Parsing */
    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
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

    /* ----------------------------------------------------------- Getter's e Setter's */
    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    /* ----------------------------------------------------------- Clone */
    public Lateral clone(){
        return new Lateral(this);
    }

    /* ----------------------------------------------------------- Habilidade */
    @Override
    public double getHabilidade() {
        double soma = this.getRemate() + this.getVelocidade()*3 + this.getCabeca() + this.getCruzamento()*3 +
                this.getDestreza()*2 + this.getPasse()*2 + this.getImpulsao() + this.getResistencia()*4;

        return soma / 17;
    }

    @Override
    public double getAdequacao(PosicaoJogador posicao) {
        double lateralParaDefesaConst = 0.8;
        double lateralParaMedioConst = 0.6;
        double lateralParaGuardaRedesConst = 0.1;
        double lateralParaAvancadoConst = 0.7;
        double adequacao = 0;

        switch (posicao){
            case GUARDA_REDES:
                adequacao = (((double) impulsao + destreza)/(2*100))*lateralParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = (((double) cabeca + impulsao + passe)/(3*100))*lateralParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) passe + velocidade + resistencia + destreza)/(4*100))*lateralParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) velocidade + impulsao + remate + cabeca + destreza)/(5*100))*lateralParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}
