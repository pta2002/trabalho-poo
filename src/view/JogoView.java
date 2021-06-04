package view;

public class JogoView {
    public void mensagens(int opcao) {
        switch (opcao) {
            case 1 : System.out.println("Escolha a equipa da casa");break;
            case 2 : System.out.println("Escolha a equipa visitante"); break;
            case 3 : System.out.println("Quer mudar o modelo tático da equipa da casa? "); break;
            case 4 : System.out.println("Quer mudar o modelo tático da equipa visitante? "); break;
        }
    }
    public void erros(int opcao) {
        switch (opcao) {
            case 1 : System.out.println("Equipa não existe");break;
            case 2 : System.out.println("Escolha uma equipa diferente da primeira"); break;
        }
    }
}
