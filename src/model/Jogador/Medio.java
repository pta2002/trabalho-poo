package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Medio extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int recuperacao;

    /* ----------------------------------------------------------- Construtores */
    /* ----------------------------------------------------------- Getter's e Setter's */
    public Medio (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int recup, List<EntradaHistorial> e) {
        super(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p,e);
        this.recuperacao = recup;
    }

    public Medio(Medio medio){
        super(medio);
        this.recuperacao = medio.getRecuperacao();
    }

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
        double soma = this.getRemate()*2 + this.getVelocidade()*2 + this.getCabeca() + this.getRecuperacao()*2 +
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
                adequacao = (((double) getImpulsao() + getDestreza()) / (2 * 100)) * medioParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = ((double) (getCabeca() + getImpulsao() + getPasse()) / (3 * 100)) * medioParaDefesaConst;
                break;
            case MEDIO:
                adequacao = medioParaMedioConst;
                break;
            case AVANCADO:
                adequacao = ((double) (getVelocidade() + getImpulsao() + getRemate() + getCabeca() + getDestreza()) / (5 * 100)) * medioParaAvancadoConst;
                break;
        }
        return adequacao;
    }

    public PosicaoJogador getPosicao() {
        return PosicaoJogador.MEDIO;
    }
}