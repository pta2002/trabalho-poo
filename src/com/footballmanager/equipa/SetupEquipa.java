package com.footballmanager.equipa;

import java.util.*;
import java.util.stream.Collectors;

import com.footballmanager.jogador.Jogador;
import com.footballmanager.jogo.ModeloTatico;

public class SetupEquipa {

    private Equipa equipa;
    private ModeloTatico modeloTatico;
    private List<Jogador> titulares;
    private List<Jogador> emCampo;
    private List<Jogador> noBanco;

    public SetupEquipa(Equipa equipa) {
        this.modeloTatico = ModeloTatico.getRandomModeloTatico();
        Random rand = new Random();
        List<Jogador> list = new ArrayList<>(equipa.getJogadores());
        Collections.shuffle(list);
        this.titulares = list.subList(0,11);
        this.emCampo = this.titulares;
    }
    public SetupEquipa(SetupEquipa setup) {
        this.titulares = setup.getTitulares();
        this.modeloTatico = setup.getModeloTatico();
        this.equipa = setup.getEquipa();
        this.emCampo = setup.getEmCampo();
        this.noBanco = setup.getNoBanco();

    }
    public SetupEquipa(Equipa equipa, ModeloTatico modeloTatico, ArrayList<Jogador> titulares, ArrayList<Jogador> noBanco) {
        this.equipa = equipa.clone();
        this.modeloTatico = modeloTatico;
        this.titulares = titulares.stream().map(Jogador::clone).collect(Collectors.toList());; ;
        this.emCampo = emCampo.stream().map(Jogador::clone).collect(Collectors.toList());
        this.noBanco = noBanco.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public List<Jogador> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Jogador> titulares) {
        this.titulares = titulares;
    }

    public List<Jogador> getEmCampo() {
        return emCampo;
    }

    public void setEmCampo(List<Jogador> emCampo) {
        this.emCampo = emCampo;
    }

    public List<Jogador> getNoBanco() {
        return noBanco;
    }

    public void setNoBanco(List<Jogador> noBanco) {
        this.noBanco = noBanco;
    }

    public ModeloTatico getModeloTatico() {
        return modeloTatico;
    }
    public void setModeloTatico(ModeloTatico modeloTatico) {
        this.modeloTatico = modeloTatico;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetupEquipa that = (SetupEquipa) o;
        return equipa.equals(that.equipa) && getModeloTatico() == that.getModeloTatico() && getTitulares().equals(that.getTitulares()) && getEmCampo().equals(that.getEmCampo()) && getNoBanco().equals(that.getNoBanco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipa, getModeloTatico(), getTitulares(), getEmCampo(), getNoBanco());
    }
    public SetupEquipa clone() {
        return new SetupEquipa(this);
    }
}
