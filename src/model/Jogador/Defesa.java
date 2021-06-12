package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Defesa extends Jogador {
    /* ---------------------------------------------------------- Construtores */
    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, List<String> e) {
        super(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p,new ArrayList<>(e));
    }

    public Defesa(Defesa d){
        super(d);
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
                adequacao = (((double) getImpulsao() + getDestreza())/(2*100))*defesaParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = defesaParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) getPasse() + getVelocidade() + getResistencia() + getDestreza())/(4*100))*defesaParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) getVelocidade() + getImpulsao() + getRemate() + getCabeca() + getDestreza())/(5*100))*defesaParaAvancadoConst;
                break;
        }

        return adequacao;
    }
}