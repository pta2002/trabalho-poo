package model.Jogo.Evento;

public class Intervalo extends EventoJogo {
    // Não acontece nada no intervalo, só precisa do tempo
    public Intervalo(double tempo) {
        super(tempo);
    }

    public String toString() {
        return "Intervalo";
    }

    public Intervalo clone() {
        return new Intervalo(getTempo());
    }
}
