package model.Jogador;

import model.Jogo.PosicaoJogador;

public class Defesa extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    /* TODO */

    /* ---------------------------------------------------------- Construtores */
    public Defesa(){
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

    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
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

    public Defesa(Defesa defesa){
        super.nomeJogador = defesa.getNomeJogador();
        super.numeroJogador = defesa.getNumeroJogador();
        super.velocidade = defesa.getVelocidade();
        super.resistencia = defesa.getResistencia();
        super.destreza = defesa.getDestreza();
        super.impulsao = defesa.getImpulsao();
        super.cabeca = defesa.getCabeca();
        super.remate = defesa.getRemate();
        super.passe = defesa.getPasse();
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
                Integer.parseInt(campos[8]));
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

        double habilidade = soma / this.getResistencia() + this.getDestreza() + this.getImpulsao() + this.getPasse() +
                this.getVelocidade() + this.getCabeca() + this.getRemate();

        return habilidade;
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