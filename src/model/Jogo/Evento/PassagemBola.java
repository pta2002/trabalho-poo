package model.Jogo.Evento;

import model.Jogador.Jogador;

/***
 * Representa um evento de passagem de bola ao longo do jogo.
 * Isto representa qualquer evento em que a bola passa de um jogador a outro, quer seja dentro da mesma equipa ou não.
 */
public class PassagemBola extends EventoJogo {
    private Jogador antes;
    private Jogador depois;

    /***
     * Construtor parameterizado
     * @param tempo Tempo, em segundos, a que ocorre a passagem
     * @param antes Jogador que perdeu a bola
     * @param depois Jogador que passou a ter a posse da bola
     */
    public PassagemBola(double tempo, Jogador antes, Jogador depois) {
        super(tempo);
        this.antes = antes.clone();
        this.depois = depois.clone();
    }

    /***
     * Devolve o jogador que tinha a bola anteriormente
     * @return O jogador que tinha a bola anteriormente
     */
    public Jogador getAntes() {
        return antes.clone();
    }

    /***
     * Devolve o jogador que passou a ter a bola
     * @return O jogador que passou a ter a bola
     */
    public Jogador getDepois() {
        return depois.clone();
    }
}
