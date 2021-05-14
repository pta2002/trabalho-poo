package view;

import model.Equipa.Equipa;

public class EquipaView {
    public void border(int op) {
        switch (op) {
            case 1:
                System.out.println("\n+------------| Menu Equipa |--------------+\n");
                break;
            case 2:
                System.out.println("\n+------------| Menu criar Equipa |--------------+\n");
                break;
        }
    }

    public void mensagens(int op) {
        switch (op) {
            case 1:
                System.out.println("Escolha uma Equipa:");
                break;
            case 2:
                System.out.println("Insira o nome da nova equipa:");
                break;
            default:
                break;
        }
    }

    public void mostrarEquipa(Equipa equipa) {
        System.out.println("\n+------------| Equipa |--------------+\n");
        System.out.println(equipa.toString());
    }

    public void mostrarOverall(Equipa equipa) {
        System.out.println("\n+------------| Overall Equipa |--------------+\n");
        System.out.println("Overall médio Defesa: " + equipa.getDefesaOverall());
        System.out.println("Overall médio Medios: " + equipa.getMediosOverall());
        System.out.println("Overall médio Avancados: " + equipa.getAvancadosOverall());

        System.out.println("Overall Total: " + (equipa.getAvancadosOverall() + equipa.getMediosOverall() + equipa.getDefesaOverall())/3);
    }

    public void errosEquipa(int op) {
        switch (op) {
            case 1:
                System.out.println("(ERROR - Equipa não existe) Insira uma equipa válida");
                break;
            case 2:
                System.out.println("(ERROR - Equipa já existe) Insira um outro nome para a equipa");
                break;
            default:
                break;
        }
    }
}
