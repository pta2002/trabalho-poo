package com.footballmanager.equipa;


import com.footballmanager.jogador.Jogador;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Equipa {
   String nome;
   String localEstadio;
   List<Jogador> jogadores;

   Equipa(Equipa equipa) {
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
      this.jogadores = jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
   }
   public SetupEquipa setup() {
       return new SetupEquipa(this);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      Equipa equipa = (Equipa) o;
      return Objects.equals(getNome(), equipa.getNome()) && Objects.equals(getLocalEstadio(), equipa.getLocalEstadio()) && Objects.equals(getJogadores(), equipa.getJogadores());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getNome(), getLocalEstadio(), getJogadores());
   }

   public double overall() {
      return 0;
   }
}
