package model;

import model.Equipa.Equipa;
import model.Jogador.Jogador;
import model.Jogo.Jogo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FootballManagerModel implements Serializable {
    /* ----------------------------------------------------------- Atributos */
    private Map<String, Equipa> equipas;
    private List<Jogo> jogos;
    private static final long serialVersionUID = 1L;

    /* ---------------------------------------------------------- Construtores */
    /***
     * Construtor vazio
     */
    public FootballManagerModel() {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }
    /***
     * Construtor parametrizado
     * @param equipas equipas
     * @param jogos jogos
     */
    public FootballManagerModel(Map<String, Equipa> equipas, List<Jogo> jogos) {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();

        equipas.replaceAll((k, v) -> v.clone());

        jogos.addAll(jogos);
    }

    /***
     * Construtor de cópia
     * @param FMModel model
     */
    public FootballManagerModel(FootballManagerModel FMModel) {
        this.equipas = FMModel.getEquipas();
        this.jogos = FMModel.getJogos();
    }

    /* --------------------------------------------------------- Getter's e Setter's */
    public Map<String, Equipa> getEquipas() {
        Map<String,Equipa> equipas = new HashMap<>();

        for(Map.Entry<String, Equipa> entry : this.equipas.entrySet()) {
            equipas.put(entry.getKey(), entry.getValue().clone());
        }

        return equipas;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        Map<String,Equipa> copiaEquipas = new HashMap<>();

        for(Map.Entry<String, Equipa> entry : equipas.entrySet()) {
            copiaEquipas.put(entry.getKey(), entry.getValue().clone());
        }

        this.equipas = copiaEquipas;
    }

    public List<Jogo> getJogos() {
        return this.jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }
    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }
    /* ---------------------------------------------------------- Retorna a equipa indicada pela key*/
    public Equipa getEquipa(String equipa) {
         return this.equipas.get(equipa);
    }

    /* ---------------------------------------------------------- Insere Jogador numa equipa*/
    public void insereJogador(Jogador jog, String equipa) {
        Equipa value = this.equipas.get(equipa);
        jog.addEquipa(equipa);
        value.insereJogador(jog);
        this.equipas.replace(equipa,value);
    }

    /* ---------------------------------------------------------- Verifica se uma equipa existe */
    public Boolean existeEquipa(String equipa ) {
      return this.equipas.containsKey(equipa);
    }

    /* ---------------------------------------------------------- Adiciona uma nova equipa no HashMap*/
    public void insereEquipa(String equipa) {
        Equipa novaEquipa = new Equipa(equipa);
        this.equipas.put(equipa,novaEquipa);
    }

    public void writeObjectFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public static FootballManagerModel readObjectFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fos = new FileInputStream(filename);
        ObjectInputStream oos = new ObjectInputStream(fos);
        FootballManagerModel r = (FootballManagerModel) oos.readObject();
        oos.close();
        return r;
    }

    public static FootballManagerModel load_from_file(String filename) throws IOException, ClassNotFoundException, LinhaIncorretaException {
          FootballManagerModel r ;
          String extension = "";
          int index;
          if ((index = filename.lastIndexOf('.')) > 0) {
              extension = filename.substring(index + 1);
          }
          if(extension.equals("ser") || extension.equals("dat") || extension.equals("o") || extension.equals("obj")) {
              r = readObjectFile(filename);
          }
          else {
              r = new FootballManagerModel();
              Parser.loadDatabase(r, filename);
          }
          return r;
    }
}