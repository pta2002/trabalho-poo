package model.Jogo.Evento;

public class Substituicao extends EventoJogo {
    private String equipa;
    private int antes;
    private int depois;

    public Substituicao(double tempo, String equipa, int antes, int depois) {
        super(tempo);
        this.equipa = equipa;
        this.antes = antes;
        this.depois = depois;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getAntes() {
        return antes;
    }

    public void setAntes(int antes) {
        this.antes = antes;
    }

    public int getDepois() {
        return depois;
    }

    public void setDepois(int depois) {
        this.depois = depois;
    }

    public String toString() {
        return "Substituição: " + this.equipa + " " + antes + " -> " + depois;
    }
}
