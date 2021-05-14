package model.Jogador;

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

}