package model.Jogo;

import model.Equipa.Equipa;
import model.Equipa.SetupEquipa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private SetupEquipa setupEquipaCasa;
    private SetupEquipa setupEquipaFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substitucoesFora ;

    public Jogo() {
        date = LocalDate.now();
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();
    }
    // Jogo novo
    public Jogo(Equipa ec, Equipa ef){
        equipaCasa = ec.getNome();
        equipaFora = ef.getNome();
        date = LocalDate.now();
        this.setupEquipaCasa = new SetupEquipa(ec); // random setup
        this.setupEquipaFora = new SetupEquipa(ef); // random setup
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();
    }
    //  Jogo no passado
    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc, List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        this.setupEquipaCasa = new SetupEquipa(jc);
        this.setupEquipaFora = new SetupEquipa(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    public Jogo(Jogo jogo) {
        this.equipaCasa = jogo.getEquipaCasa();
        this.equipaFora = jogo.getEquipaFora();
        this.golosCasa = jogo.getGolosCasa();
        this.golosFora = jogo.getGolosFora();
        this.date = jogo.getDate();
        this.setupEquipaCasa = jogo.getSetupEquipaCasa();
        this.setupEquipaFora = jogo.getSetupEquipaFora();
        this.substituicoesCasa = jogo.getSubstituicoesCasa();
        this.substitucoesFora = jogo.getSubstitucoesFora();

    }
    public SetupEquipa getSetupEquipaCasa() {
        return setupEquipaCasa.clone();
    }

    public void setSetupEquipaCasa(SetupEquipa setupEquipaCasa) {
        this.setupEquipaCasa = setupEquipaCasa.clone();
    }

    public SetupEquipa getSetupEquipaFora() {
        return setupEquipaFora.clone();
    }

    public void setSetupEquipaFora(SetupEquipa setupEquipaFora) {
        this.setupEquipaFora = setupEquipaFora.clone();
    }

    public String getEquipaCasa() {
        return equipaCasa;
    }

    public void setEquipaCasa(Equipa equipaCasa) {
        this.equipaCasa = equipaCasa.getNome();
        this.setupEquipaCasa = new SetupEquipa(equipaCasa);
    }
    public void setEquipaCasa(String equipaCasa) {
        this.equipaCasa = equipaCasa;
    }

    public String getEquipaFora() {
        return equipaFora;
    }
    public void setEquipaFora(Equipa equipaFora) {
        this.equipaFora = equipaFora.getNome();
        this.setupEquipaFora = new SetupEquipa(equipaFora);
    }

    public void setEquipaFora(String equipaFora) {
        this.equipaFora = equipaFora;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosFora() {
        return golosFora;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Map<Integer, Integer> getSubstituicoesCasa() {
        return substituicoesCasa;
    }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    public Map<Integer, Integer> getSubstitucoesFora() {
        return substitucoesFora;
    }

    public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {
        this.substitucoesFora = substitucoesFora;
    }


    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }
    public Jogo clone() {
        return new Jogo(this);

    }

    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
        //+ " -> " + substituicoesCasa.toString()
        //+ " -> " + substitucoesFora.toString();
    }

    public void setModeloTaticoCasa(ModeloTatico mt) {
        if (setupEquipaCasa == null) System.out.println("tone");
        this.setupEquipaCasa.setModeloTatico(mt);
    }
    public void setModeloTaticoFora(ModeloTatico mt) {
        this.setupEquipaFora.setModeloTatico(mt);
    }
}

