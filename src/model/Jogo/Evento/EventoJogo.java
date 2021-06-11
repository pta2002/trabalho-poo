package model.Jogo.Evento;

import java.io.Serializable;

/***
 * Representa um evento que ocorreu no jogo, a um determinado tempo
 */
public abstract class EventoJogo implements Serializable {
    private double tempo;

    public EventoJogo(double tempo) {
        this.tempo = tempo;
    }

    /***
     * Devolve o tempo, em segundos, em que o evento ocorreu
     * @return O tempo, em segundos, em que o evento ocorreu
     */
    public double getTempo() {
        return tempo;
    }
}
