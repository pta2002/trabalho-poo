package model.Jogo.Evento;

/***
 * Representa uma equipa que acabou de opter posse de bola, por exemplo, ao começar o jogo.
 */
public class PosseBola extends EventoJogo {
    private String equipa;
    private int jogador;

    /***
     * Cria um evento de posse de bola para uma equipa
     * @param tempo O tempo, em segundos, a que o evento ocorre
     * @param equipa A equipa que toma posse da bola
     * @param jogador O número do jogador que tem a bola
     */
    public PosseBola(double tempo, String equipa, int jogador) {
        super(tempo);
        this.equipa = equipa;
        this.jogador = jogador;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public String toString() {
        return "Posse: " + equipa + " " + jogador;
    }
}
