package model.Jogo.Evento;

/***
 * Representa uma equipa que acabou de opter posse de bola, por exemplo, ao começar o jogo.
 */
public class PosseBola extends EventoJogo {
    private String equipa;

    /***
     * Cria um evento de posse de bola para uma equipa
     * @param tempo O tempo, em segundos, a que o evento ocorre
     * @param equipa A equipa que toma posse da bola
     */
    public PosseBola(double tempo, String equipa) {
        super(tempo);
        this.equipa = equipa;
    }

    /**
     * Devolve a equipa que possui a bola
     * @return A equipa que obteve posse da bola
     */
    public String getEquipa() {
        return equipa;
    }
}
