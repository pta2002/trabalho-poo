
package model.Equipa;
import model.Jogador.*;
import model.Jogo.ModeloTatico;
import model.Jogo.PosicaoJogador;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


public class SetupEquipa implements Serializable {
    private Equipa equipa;
    private ModeloTatico modeloTatico;
    private List<Integer> titulares;
    private List<Integer> emCampo;
    private List<Integer> noBanco;
    private static final long serialVersionUID = 3L;


    public SetupEquipa(Equipa equipa) {
        this.modeloTatico = ModeloTatico.getRandomModeloTatico();
        List<Integer> list = equipa.getJogadores().stream().map(Jogador::getNumeroJogador).collect(Collectors.toList());
        //Collections.shuffle(list);
        List<Integer> defesasTitulares = equipa.getJogadores().stream()
                                                        .filter(jogador -> jogador instanceof Defesa || jogador instanceof Lateral)
                                                        .limit(modeloTatico.getNumDefesas())
                                                        .map(Jogador::getNumeroJogador).collect(Collectors.toList());

        List<Integer> mediosTitulares = equipa.getJogadores().stream()
                .filter(jogador -> jogador instanceof Medio)
                .limit(modeloTatico.getNumMedios())
                .map(Jogador::getNumeroJogador).collect(Collectors.toList());

        List<Integer> avancadosTitulares = equipa.getJogadores().stream()
                .filter(jogador -> jogador instanceof Avancado)
                .limit(modeloTatico.getNumAvancados())
                .map(Jogador::getNumeroJogador).collect(Collectors.toList());

        this.titulares = new ArrayList<>();
        titulares.addAll(defesasTitulares);
        titulares.addAll(mediosTitulares);
        titulares.addAll(avancadosTitulares);

        int redes = equipa.getJogadores().stream()
                .filter(j-> j instanceof GuardaRedes)
                .limit(1)
                .map(Jogador::getNumeroJogador).findAny().get();

        titulares.add(redes);

        list.removeAll(this.titulares);

        this.noBanco = new ArrayList<>(list.subList(0,7));

        this.emCampo = new ArrayList<>(this.titulares);
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
        this.titulares = new ArrayList<>(titulares);
        this.emCampo = new ArrayList<>(titulares);
        this.noBanco = new ArrayList<>(noBanco);
    }

    public SetupEquipa(List<Integer> titulares) {
        this.titulares = new ArrayList<>(titulares);
        this.emCampo = new ArrayList<>(titulares);
        this.noBanco = new ArrayList<>();
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

    public Integer getGuardaRedes() {
        // Não vale a pena complicar, só existe um guarda redes e é sempre o primeiro
        return this.emCampo.get(0);
    }

    public List<Integer> getDefesas() {
        int nDefesas = modeloTatico.getNumDefesas();
        List<Integer> defesas = new ArrayList<>(nDefesas);

        for (int i = 1; i < nDefesas + 1; i++) {
            defesas.add(emCampo.get(i));
        }

        return defesas;
    }

    public List<Integer> getMedios() {
        int nMedios = modeloTatico.getNumMedios();
        int nDefesas = modeloTatico.getNumDefesas();
        List<Integer> medios = new ArrayList<>(nMedios);

        for (int i = 1 + nDefesas; i < nMedios + 1 + nDefesas; i++) {
            medios.add(emCampo.get(i));
        }

        return medios;
    }

    public List<Integer> getAvancados() {
        int nMedios = modeloTatico.getNumMedios();
        int nDefesas = modeloTatico.getNumDefesas();
        int nAvancados = modeloTatico.getNumAvancados();
        List<Integer> avancados = new ArrayList<>(nAvancados);

        for (int i = 1 + nDefesas + nMedios; i < nAvancados + 1 + nDefesas + nMedios; i++) {
            avancados.add(emCampo.get(i));
        }

        return avancados;
    }

    public PosicaoJogador getPosicaoJogador(int jogador) {
        for (int i = 0; i < emCampo.size(); i++) {
            if (emCampo.get(i) == jogador) {
                if (i == 0) {
                    return PosicaoJogador.GUARDA_REDES;
                } else if (i < 1 + modeloTatico.getNumDefesas()) {
                    return PosicaoJogador.DEFESA;
                } else if (i < 1 + modeloTatico.getNumDefesas() + modeloTatico.getNumMedios()) {
                    return PosicaoJogador.MEDIO;
                } else {
                    return PosicaoJogador.AVANCADO;
                }
            }
        }

        return null;
    }

    public void substituir(int antes, int depois) {
        for (int i = 0; i < emCampo.size(); i++) {
            if (emCampo.get(i) == antes) {
                emCampo.set(i, depois);
            }
        }
    }
}
