package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Avancado extends Jogador {
    /* ----------------------------------------------------------- Construtores */
    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, List<EntradaHistorial> e) {
        super(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p,e);
    }

    public Avancado(Avancado avancado){
        super(avancado);
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
                adequacao = (((double) getImpulsao() + getDestreza()) / (2 * 100)) * avancadoParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = (((double) getCabeca() + getImpulsao() + getPasse()) / (3 * 100)) * avancadoParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) getPasse() + getVelocidade() + getResistencia() + getDestreza()) / (4 * 100)) * avancadoParaMedioConst;
                break;
            case AVANCADO:
                adequacao = avancadoParaAvancadoConst;
                break;
        }
        return adequacao;
    }

    @Override
    public PosicaoJogador getPosicao() {
        return PosicaoJogador.AVANCADO;
    }
}