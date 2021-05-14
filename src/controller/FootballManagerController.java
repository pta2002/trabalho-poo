package controller;

import model.FootballManagerModel;

import java.util.Arrays;

public class FootballManagerController extends Menu {

    public FootballManagerController(String[] opcoes) {
        super.opcoes = Arrays.asList(opcoes);
        super.op = 0;
    }

    @Override
    public void executa(FootballManagerModel model) {
            do {
                showMenu();
                this.op = lerOpcao();
                switch (op) {
                    case 1:
                        JogadoresController jogadoresController = new JogadoresController();
                        jogadoresController.executa(model);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        EquipaController equipaController = new EquipaController(new String[]{"Ver Jogadores", "Ver overall"});
                        equipaController.executa(model);
                        break;
                }
            } while (this.op != 0);
        }
}
