package model.Equipa;

import model.Jogador.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Equipa implements Serializable {
    /* ----------------------------------------------------------- Atributos */
    private String nome;
    private Map<Integer,Jogador> jogadores;
    private static final long serialVersionUID = 2L;


    /* ----------------------------------------------------------- Construtores */
    public Equipa(String nomeEquipa) {
        nome=nomeEquipa;
        jogadores = new HashMap<>();
    }

    public Equipa(Equipa equipa) {
        this.nome = equipa.getNome();

        HashMap<Integer,Jogador> jogadores = new HashMap<>();
        for (Map.Entry<Integer,Jogador> e: equipa.jogadores.entrySet()) {
            jogadores.put(e.getKey(),e.getValue().clone());
        }
        this.jogadores = jogadores;
    }

    /* ----------------------------------------------------------- Parsing */
    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) {
        jogadores.put(j.getNumeroJogador(),j.clone());
    }

    public String getNome(){
        return nome;
    }

    public double getDefesaOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores.values()) {
            if (jogador instanceof Defesa) {total += ((Defesa) jogador).getHabilidade(); cont++;}
            if (jogador instanceof Lateral) {total += ((Lateral) jogador).getHabilidade(); cont++;}
            if (jogador instanceof GuardaRedes) {total += ((GuardaRedes) jogador).getHabilidade(); cont++;}
        }

        if (cont != 0)
            return total/cont;
        else
            return 0;
    }

    public double getMediosOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores.values()) {
            if (jogador instanceof Medio) {total += ((Medio) jogador).getHabilidade(); cont++;}
        }
        if (cont != 0)
            return total/cont;
        else
            return 0;
    }

    public double getAvancadosOverall() {
        double total = 0;
        int cont = 0;
        for (Jogador jogador : this.jogadores.values()) {
            if (jogador instanceof Avancado) {total += ((Avancado) jogador).getHabilidade(); cont++;}
        }
        if (cont != 0)
            return total/cont;
        else return 0;
    }

    public double getOverall() {
        return (getMediosOverall() + getAvancadosOverall() + getDefesaOverall()) / 3;
    }

    public boolean existeJogador(int numero) {
        boolean existe = false;
        for (Jogador jogador: this.jogadores.values()) {
            if (jogador.getNumeroJogador() == numero) existe = true;
        }

        return existe;
    }

    public Jogador getJogador(int numero) {
        for (Jogador jogador: this.jogadores.values()) {
            if (jogador.getNumeroJogador() == numero) return jogador;
        }

        return null;
    }

    public void removeJogador(Jogador jogador) {
        this.jogadores.remove(jogador.getNumeroJogador());
    }

    /* ----------------------------------------------------------- Clone */
    @Override
    public Equipa clone() {
        return new Equipa(this);
    }

    /* ----------------------------------------------------------- toString */
    @Override
    public String toString(){
        return nome;
    }

    public List<Jogador> getJogadores() {
        return this.jogadores.values().stream().map(Jogador::clone).collect(Collectors.toList());
    }
    public void setJogadores(List<Jogador> jgs) {
        jgs.forEach(x -> this.jogadores.put(x.getNumeroJogador(),x));
    }

}


