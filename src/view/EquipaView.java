package view;

import model.Equipa.Equipa;

public class EquipaView {
    public void equipaMenu(int op) {
        switch (op) {
            case 1:
                System.out.println("\n+------------| Menu Equipa |--------------+\n");
                System.out.println("Escolha uma Equipa:");
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
        System.out.println("Overall médio Defesa: " + equipa.getAvancadosOverall());

        System.out.println("Overall Total: " + (equipa.getAvancadosOverall() + equipa.getMediosOverall() + equipa.getDefesaOverall())/3);
    }
}
