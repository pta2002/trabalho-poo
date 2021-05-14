package model.Equipa;

import model.Jogador.*;

import java.util.ArrayList;
import java.util.List;

public class Equipa {
    /* ----------------------------------------------------------- Atributos */
    private String nome;
    private List<Jogador> jogadores;

    /* ----------------------------------------------------------- Construtores */
    public Equipa(String nomeE) {
        nome=nomeE;
        jogadores = new ArrayList<>();
    }

    public Equipa(Equipa equipa) {
        this.nome = equipa.getNome();

        List<Jogador> jogadores = new ArrayList<>();
        for (Jogador jogador: equipa.jogadores) {
            jogadores.add(jogador.clone());
        }

        this.jogadores = jogadores;
    }

    /* ----------------------------------------------------------- Parsing */
    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) {
        jogadores.add(j.clone());
    }

    public String getNome(){
        return nome;
    }

    public double getDefesaOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores) {
            if (jogador instanceof Defesa) {total += ((Defesa) jogador).getHabilidade(); cont++;}
            if (jogador instanceof Lateral) {total += ((Lateral) jogador).getHabilidade(); cont++;}
            if (jogador instanceof GuardaRedes) {total += ((GuardaRedes) jogador).getHabilidade(); cont++;}
        }
        return total/cont;
    }

    public double getMediosOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores) {
            if (jogador instanceof Medio) {total += ((Medio) jogador).getHabilidade(); cont++;}
        }
        return total/cont;
    }

    public double getAvancadosOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores) {
            if (jogador instanceof Avancado) {total += ((Avancado) jogador).getHabilidade(); cont++;}
        }
        return total/cont;
    }

    public boolean existeJogador(int numero) {
        boolean existe = false;
        for (Jogador jogador: this.jogadores) {
            if (jogador.getNumeroJogador() == numero) existe = true;
        }

        return existe;
    }

    public Jogador getJogador(int numero) {
        for (Jogador jogador: this.jogadores) {
            if (jogador.getNumeroJogador() == numero) return jogador;
        }

        return null;
    }

    public void removeJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }

    /* ----------------------------------------------------------- Clone */
    @Override
    public Equipa clone() {
        return new Equipa(this);
    }

    /* ----------------------------------------------------------- toString */
    @Override
    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }

}


