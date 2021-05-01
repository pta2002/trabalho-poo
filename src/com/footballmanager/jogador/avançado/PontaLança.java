package com.footballmanager.jogador.avançado;

public class PontaLança extends Avançado{
    private double protecaoBola;
    public PontaLança(String nome, double velocidade, double resistencia, double destreza, double impulsao, double jogoDeCabeca, double remate, double capacidadeDePasse, double habilidade, double desmarcacao, double protecaoBola) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse, habilidade, desmarcacao);
        this.protecaoBola = protecaoBola;
    }

    public double getProtecaoBola(){
        return this.protecaoBola;
    }

    public void setProtecaoBola(double protecaoBola){
        this.protecaoBola = protecaoBola;
    }

    @java.lang.Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PontaLança that = (PontaLança) object;
        return java.lang.Double.compare(that.getProtecaoBola(), getProtecaoBola()) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getProtecaoBola());
    }

    public Avançado clone() {
        return new PontaLança(this);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PontaLança{" +
                "protecaoBola=" + protecaoBola +
                '}';
    }

    @Override
    abstract public double getHabilidade() ;
}
