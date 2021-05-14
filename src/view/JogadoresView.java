package view;

public class JogadoresView {

    public void CriarJogadorMenu(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Nome do Jogador:");break;
            case 2:
                System.out.println("Posição do Jogador:");break;
            case 3:
                System.out.println("Numero da camisola:");break;
            case 4:
                System.out.println("Velocidade:");break;
            case 5:
                System.out.println("Resistencia:");break;
            case 6:
                System.out.println("Destreza:");break;
            case 7:
                System.out.println("Impulsao:");break;
            case 8:
                System.out.println("Cabeça:");break;
            case 9:
                System.out.println("Remate:");break;
            case 10:
                System.out.println("Passe:");break;
            case 11:
                System.out.println("Elasticidade:");break;
            case 12:
                System.out.println("Cruzamento:");break;
            case 13:
                System.out.println("Recuperacao:");break;
            case 14:
                System.out.println("Nome da equipa:");break;
            default: break;
        }
    }

    public void errosJogador(int op) {
        switch (op) {
            case 1:
                System.out.println("(ERROR - Equipa não existe) Insira uma equipa válida");
                break;
            case 2:
                System.out.println("(ERROR - Posição não existe) Insira uma Posição válida");
                break;
            default:
                break;
        }
    }

    public void border() {
        System.out.println("\n+------------| Criação de jogador |--------------+\n");
    }
}
