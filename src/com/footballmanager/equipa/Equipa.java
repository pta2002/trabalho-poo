package com.footballmanager.equipa;

import com.footballmanager.jogador.Jogador;
import com.footballmanager.jogo.ModeloTatico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Equipa {
   String nome;
   String localEstadio;
   List<Jogador> jogadores;

   public Equipa(Equipa equipa) {
      this.nome = equipa.getNome();
      this.localEstadio = equipa.getLocalEstadio();
      this.jogadores = equipa.getJogadores();
   }
   public Equipa(String nome, String localEstadio, List<Jogador> jogadores) {
      this.nome = nome;
      this.localEstadio = localEstadio;
      this.jogadores = jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public String getLocalEstadio() {
      return localEstadio;
   }
   public void setLocalEstadio(String localEstadio) {
      this.localEstadio = localEstadio;
   }

   public List<Jogador> getJogadores() {
      return jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
   }

   public Equipa clone() {
      return new Equipa(this);
   }

   public void setJogadores(List<Jogador> jogadores) {
      this.jogadores = jogadores;
   }
   public SetupEquipa setup() {
       return new SetupEquipa(this);
   }
}
