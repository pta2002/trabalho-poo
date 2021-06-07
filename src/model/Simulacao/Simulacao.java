package model.Simulacao;

import model.Equipa.Equipa;
import model.Simulacao.Evento.EventoJogo;

import java.util.Random;

public class Simulacao {
    private Random randomizer;

    private Equipa equipaCasa;
    private Equipa equipaVisitante;

    private int golosCasa;
    private int golosVisitante;

    private EventoJogo ultimoEvento;

    /***
     * Cria uma simulação entre duas equipas
     * @param equipaCasa A equipa de casa
     * @param equipaVisitante A equipa visitante
     */
    public Simulacao(Equipa equipaCasa, Equipa equipaVisitante) {
        this.equipaCasa = equipaCasa.clone();
        this.equipaVisitante = equipaVisitante.clone();
        this.randomizer = new Random();

        this.golosCasa = 0;
        this.golosVisitante = 0;

        this.ultimoEvento = null;
    }

    /***
     * Construtor parameterizado para uma simulação
     * @param randomizer Randomizador a ser utilizado
     * @param equipaCasa Equipa de casa
     * @param equipaVisitante Equipa visitante
     * @param golosCasa Golos de casa
     * @param golosVisitante Golos do visitante
     * @param ultimoEvento Último evento que ocorreu
     */
    public Simulacao(Random randomizer, Equipa equipaCasa, Equipa equipaVisitante, int golosCasa, int golosVisitante, EventoJogo ultimoEvento) {
        this.randomizer = randomizer;
        this.equipaCasa = equipaCasa.clone();
        this.equipaVisitante = equipaVisitante.clone();
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
        this.ultimoEvento = ultimoEvento;
    }

    /***
     * Construtor de cópia de uma simulação
     * @param simulacao Simulação a copiar
     */
    public Simulacao(Simulacao simulacao) {
        this.randomizer = simulacao.randomizer;
        this.equipaCasa = simulacao.equipaCasa.clone();
        this.equipaVisitante = simulacao.equipaVisitante.clone();
        this.golosCasa = simulacao.golosCasa;
        this.golosVisitante = simulacao.golosVisitante;
        // TODO: Clonar o evento!
        this.ultimoEvento = simulacao.ultimoEvento;
    }

    /***
     * Clona uma simulação
     * @return Uma cópia profunda desta simulação
     */
    public Simulacao clone() {
        return new Simulacao(this);
    }

    public Equipa getEquipaCasa() {
        return equipaCasa.clone();
    }

    public void setEquipaCasa(Equipa equipaCasa) {
        this.equipaCasa = equipaCasa.clone();
    }

    public Equipa getEquipaVisitante() {
        return equipaVisitante.clone();
    }

    public void setEquipaVisitante(Equipa equipaVisitante) {
        this.equipaVisitante = equipaVisitante.clone();
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public EventoJogo getUltimoEvento() {
        // TODO: clonar evento
        return ultimoEvento;
    }

    public void setUltimoEvento(EventoJogo ultimoEvento) {
        // TODO: clonar evento
        this.ultimoEvento = ultimoEvento;
    }
}
