
package model.Equipa;
import model.Jogador.Jogador;
import model.Jogo.ModeloTatico;

import java.util.*;
import java.util.stream.Collectors;


public class SetupEquipa {
    private Equipa equipa;
    private ModeloTatico modeloTatico;
    private List<Integer> titulares;
    private List<Integer> emCampo;
    private List<Integer> noBanco;
    private static final Random random = new Random();

    public SetupEquipa(Equipa equipa) {
        this.modeloTatico = ModeloTatico.getRandomModeloTatico();
        Random rand = new Random();
        List<Integer> list = equipa.getJogadores().stream().map(Jogador::getNumeroJogador).collect(Collectors.toList());
        Collections.shuffle(list);
        this.titulares = list.subList(0,11);
        list.removeAll(this.titulares);
        this.noBanco =  list.subList(0,4);
        this.emCampo = this.titulares;
    }
    public SetupEquipa(SetupEquipa setup) {
        this.titulares = setup.getTitulares();
        this.modeloTatico = setup.getModeloTatico();
        this.equipa = setup.getEquipa();
        this.emCampo = setup.getEmCampo();
        this.noBanco = setup.getNoBanco();

    }
    public SetupEquipa(Equipa equipa, ModeloTatico modeloTatico, ArrayList<Integer> titulares, ArrayList<Integer> noBanco) {
        this.equipa = equipa.clone();
        this.modeloTatico = modeloTatico;
        this.titulares = new ArrayList<Integer>(titulares);
        this.emCampo = new ArrayList<Integer>(titulares);
        this.noBanco = new ArrayList<Integer>(noBanco);
    }
    public SetupEquipa(List<Integer> titulares) {
        this.titulares = new ArrayList<>(titulares);
        this.emCampo = new ArrayList<Integer>();
        this.noBanco = new ArrayList<Integer>();
    }

    public List<Integer> getTitulares() {
        return new ArrayList<>(titulares);
    }

    public void setTitulares(List<Integer> titulares) {
        this.titulares = new ArrayList<>(titulares);
    }

    public List<Integer> getEmCampo() {
            return new ArrayList<>(this.emCampo);
    }

    public void setEmCampo(List<Integer> emCampo) {
        this.emCampo = new ArrayList<>(emCampo);
    }

    public List<Integer> getNoBanco() {
        return new ArrayList<>(noBanco);
    }

    public void setNoBanco(List<Integer> noBanco) {
        this.noBanco = new ArrayList<>(noBanco);
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
        this.equipa = equipa.clone();
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
