package model.Jogador;

import model.Jogo.PosicaoJogador;

public class Lateral extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int cruzamento;

    /* ----------------------------------------------------------- Construtores */
    public Lateral(){
        super.nomeJogador = "unknown";
        super.numeroJogador = 0;
        super.velocidade = 50;
        super.resistencia = 50;
        super.destreza = 50;
        super.impulsao = 50;
        super.cabeca = 50;
        super.remate = 50;
        super.passe = 50;

        this.cruzamento = 50;
    }

    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz) {
        super.nomeJogador = nomeJ;
        super.numeroJogador = numeroJ;
        super.velocidade = vel;
        super.resistencia = res;
        super.destreza = des;
        super.impulsao = imp;
        super.cabeca = cab;
        super.remate = rem;
        super.passe = p;

        this.cruzamento = cruz;
    }

    public Lateral(Lateral lateral){
        super.nomeJogador = lateral.getNomeJogador();
        super.numeroJogador = lateral.getNumeroJogador();
        super.velocidade = lateral.getVelocidade();
        super.resistencia = lateral.getResistencia();
        super.destreza = lateral.getDestreza();
        super.impulsao = lateral.getImpulsao();
        super.cabeca = lateral.getCabeca();
        super.remate = lateral.getRemate();
        super.passe = lateral.getPasse();
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
                Integer.parseInt(campos[9]));
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

        double habilidade = soma / this.getResistencia() + this.getDestreza() + this.getImpulsao() + this.getPasse() +
                this.getVelocidade() + this.getCabeca() + this.getRemate() + this.getCruzamento();

        return habilidade;
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
                adequacao = ((impulsao + destreza)/(2*100))*lateralParaGuardaRedesConst;
                break;
            case DEFESA:
                adequacao = ((cabeca + impulsao + passe)/(3*100))*lateralParaDefesaConst;
                break;
            case MEDIO:
                adequacao = ((passe + velocidade + resistencia + destreza)/(4*100))*lateralParaMedioConst;
                break;
            case AVANCADO:
                adequacao = ((velocidade + impulsao + remate + cabeca + destreza)/(5*100))*lateralParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}
