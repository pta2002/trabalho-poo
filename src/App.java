import controller.FootballManagerController;
import model.FootballManagerModel;
import model.LinhaIncorretaException;
import model.Parser;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws LinhaIncorretaException {
        FootballManagerModel model = new FootballManagerModel();
        Parser.loadDatabase(model);
        FootballManagerController controller = new FootballManagerController(new String[]{"Criar Jogador",
                "Criar equipa", "Efetuar transferências", "Inspecionar equipa", "Listar Equipas","Simular partida", "Gravar"});
        controller.executa(model);
    }
}
