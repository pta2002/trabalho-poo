package model.Jogador;

public class EntradaHistorial {
    private String equipa;
    private int numero;

    public EntradaHistorial(String equipa, int numero) {
        this.equipa = equipa;
        this.numero = numero;
    }
    public EntradaHistorial(EntradaHistorial h) {
        this.equipa = h.equipa;
        this.numero = h.numero;
    }

    public String getEquipa() {
        return equipa;
    }

    
    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EntradaHistorial clone() {
        return new EntradaHistorial(this);
    }
}
