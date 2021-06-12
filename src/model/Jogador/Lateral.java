package model.Jogador;

import model.Jogo.PosicaoJogador;

import java.util.ArrayList;
import java.util.List;

public class Lateral extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int cruzamento;

    /* ----------------------------------------------------------- Construtores */
    /* ----------------------------------------------------------- Parsing */
    public Lateral (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruzamento, List<String> e) {
        super(nomeJ,numeroJ,vel,res,des,imp,cab,rem,p,new ArrayList<>(e));
        this.cruzamento = cruzamento;
    }

    public Lateral(Lateral lateral){
        super(lateral);
        this.cruzamento = lateral.getCruzamento();
    }


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
                adequacao = (((double) getImpulsao() + getDestreza())/(2*100))*lateralParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = (((double) getCabeca() + getImpulsao() + getPasse())/(3*100))*lateralParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) getPasse() + getVelocidade() + getResistencia() + getDestreza())/(4*100))*lateralParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) getVelocidade() + getImpulsao() + getRemate() + getCabeca() + getDestreza())/(5*100))*lateralParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}
