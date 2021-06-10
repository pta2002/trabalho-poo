package model.Jogador;

import model.Jogo.PosicaoJogador;

public class GuardaRedes extends Jogador {
    /* ----------------------------------------------------------- Atributos */
    private int elasticidade;

    /* ----------------------------------------------------------- Construtores */
    public GuardaRedes(){
        super.nomeJogador = "unknown";
        super.numeroJogador = 0;
        super.velocidade = 50;
        super.resistencia = 50;
        super.destreza = 50;
        super.impulsao = 50;
        super.cabeca = 50;
        super.remate = 50;
        super.passe = 50;

        this.elasticidade = 50;
    }

    public GuardaRedes (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int elast) {
        super.nomeJogador = nomeJ;
        super.numeroJogador = numeroJ;
        super.velocidade = vel;
        super.resistencia = res;
        super.destreza = des;
        super.impulsao = imp;
        super.cabeca = cab;
        super.remate = rem;
        super.passe = p;

        this.elasticidade = elast;
    }

    public GuardaRedes(GuardaRedes guardaRedes){
        super.nomeJogador = guardaRedes.getNomeJogador();
        super.numeroJogador = guardaRedes.getNumeroJogador();
        super.velocidade = guardaRedes.getVelocidade();
        super.resistencia = guardaRedes.getResistencia();
        super.destreza = guardaRedes.getDestreza();
        super.impulsao = guardaRedes.getImpulsao();
        super.cabeca = guardaRedes.getCabeca();
        super.remate = guardaRedes.getRemate();
        super.passe = guardaRedes.getPasse();
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
                Integer.parseInt(campos[9]));
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

        double habilidade = soma / this.getResistencia() + this.getDestreza() + this.getImpulsao() + this.getPasse() +
                this.getVelocidade() + this.getCabeca() + this.getRemate() + this.getElasticidade();

        return habilidade;
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
                adequacao = (((double) cabeca + impulsao + passe)/(3*100))*redesParaDefesaConst;
                break;
            case MEDIO:
                adequacao = (((double) passe + velocidade + resistencia + destreza) / (4 * 100)) * redesParaMedioConst;
                break;
            case AVANCADO:
                adequacao = (((double) velocidade + impulsao + remate + cabeca + destreza)/(5*100))*redesParaAvancadoConst;
                break;
        }
        return adequacao;
    }
}
