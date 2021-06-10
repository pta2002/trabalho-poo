package model.Jogador;

import model.Jogo.PosicaoJogador;

public class Avancado extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    /* TODO */

    /* ----------------------------------------------------------- Construtores */
    public Avancado(){
        super.nomeJogador = "unknown";
        super.numeroJogador = 0;
        super.velocidade = 50;
        super.resistencia = 50;
        super.destreza = 50;
        super.impulsao = 50;
        super.cabeca = 50;
        super.remate = 50;
        super.passe = 50;
    }

    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super.nomeJogador = nomeJ;
        super.numeroJogador = numeroJ;
        super.velocidade = vel;
        super.resistencia = res;
        super.destreza = des;
        super.impulsao = imp;
        super.cabeca = cab;
        super.remate = rem;
        super.passe = p;
    }

    public Avancado(Avancado avancado){
        super.nomeJogador = avancado.getNomeJogador();
        super.numeroJogador = avancado.getNumeroJogador();
        super.velocidade = avancado.getVelocidade();
        super.resistencia = avancado.getResistencia();
        super.destreza = avancado.getDestreza();
        super.impulsao = avancado.getImpulsao();
        super.cabeca = avancado.getCabeca();
        super.remate = avancado.getRemate();
        super.passe = avancado.getPasse();
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
                Integer.parseInt(campos[8]));
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