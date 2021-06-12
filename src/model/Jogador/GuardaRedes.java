package model.Jogador;

import javafx.geometry.Pos;
import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class GuardaRedes extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int elasticidade;

    /* ----------------------------------------------------------- Construtores */
    public GuardaRedes (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int elast, List<String> e) {
        super(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p,new ArrayList<>(e));
        this.elasticidade = elast;

    }

    public GuardaRedes(GuardaRedes guardaRedes){
        super(guardaRedes);
        this.elasticidade = guardaRedes.getElasticidade();
    }

    /* ----------------------------------------------------------- Parsing */
    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
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
    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }

    /* ----------------------------------------------------------- Getter's e Setter's */
    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    /* ----------------------------------------------------------- Habilidade */
    @Override
    public double getHabilidade() {
        double soma = this.getRemate() + this.getVelocidade() + this.getCabeca()  + this.getElasticidade()*4 +
                this.getDestreza()*3 + this.getPasse() + this.getImpulsao()*4 + this.getResistencia();

        return soma / 16;
    }

    public double getAdequacao(PosicaoJogador posicao) {
        double redesParaDefesaConst = 0.4;
        double redesParaMedioConst = 0.3;
        double redesParaGuardaRedesConst = 1;
        double redesParaAvancadoConst = 0.1;
        double adequacao = 0;

        switch (posicao) {
            case GUARDA_REDES:
                adequacao = redesParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = (((double) getCabeca() + getImpulsao() + getPasse())/(3*100))*redesParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) getPasse() + getVelocidade() + getVelocidade() + getDestreza()) / (4 * 100)) * redesParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) getVelocidade() + getImpulsao() + getRemate() + getCabeca() + getDestreza())/(5*100))*redesParaAvancadoConst;
                break;
        }
        return adequacao;
    }

    public PosicaoJogador getPosicao() {
        return PosicaoJogador.GUARDA_REDES;
    }
}
