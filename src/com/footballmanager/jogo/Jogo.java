package com.footballmanager.jogo;

import com.footballmanager.equipa.SetupEquipa;
import com.footballmanager.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Jogo {
    private SetupEquipa equipaCasa;
    private SetupEquipa equipaVisitante;
    private LocalDateTime tempoDataJogo;
    private ArrayList<Jogador> expulsos;
    private int goloEquipaCasa;
    private int goloEquipaVisitante;
}
