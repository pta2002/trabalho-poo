package model.Jogo.Evento;

import model.Equipa.Equipa;
import model.Jogador.Jogador;

/***
 * Representa um golo no jogo
 */
public class Golo extends EventoJogo {
    private Jogador marcou;
    private Equipa sofreu;

    /***
     * Construtor parameterizado
     * @param tempo O tempo, em segundos, em que o golo foi marcado
     * @param marcou O jogador que marcou o golo
     * @param sofreu A equipa que sofreu o golo
     */
    public Golo(double tempo, Jogador marcou, Equipa sofreu) {
        super(tempo);
        this.marcou = marcou.clone();
        this.sofreu = sofreu.clone();
    }

    /***
     * Devolve o jogador que marcou o golo
     * @return O jogador que marcou o golo
     */
    public Jogador getMarcou() {
        return marcou.clone();
    }

    /***
     * Devolve a equipa que sofreu o golo
     * @return A equipa que sofreu o golo
     */
    public Equipa getSofreu() {
        return sofreu.clone();
    }
}
