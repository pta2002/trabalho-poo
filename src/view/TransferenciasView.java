package view;

public class TransferenciasView {
    public void border(int op) {
        switch (op) {
            case 1:
                System.out.println("\n+------------| Menu Transferências |--------------+\n");
                break;
            default:
                break;
        }
    }

    public void mensagens(int op) {
        switch (op) {
            case 1:
                System.out.println("Escolha uma equipa para retirar um jogador");
                break;
            case 2:
                System.out.println("Escolha uma equipa para transferir o jogador:");
                break;
            default:
                break;
        }
    }

    public void errosTransferencia(int op) {
        switch (op) {
            case 1:
                System.out.println("(ERROR - número de camisola já existe na nova Equipa) Insira um novo número para o jogador");
                break;
            default:
                break;
        }
    }
}
