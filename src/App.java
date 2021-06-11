import controller.FXFootballManagerController;
import controller.FootballManagerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FootballManagerModel;
import model.LinhaIncorretaException;
import model.Parser;
import view.FXListaEquipasView;
import view.FootballManagerView;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    public static void main(String[] args) throws LinhaIncorretaException {
//        Parser.loadDatabase(model);
//        FootballManagerController controller = new FootballManagerController(new String[]{"Criar Jogador",
//                "Criar equipa", "Efetuar transferências", "Inspecionar equipa", "Listar Equipas","Simular partida", "Gravar"});
//        controller.executa(model);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FootballManagerModel model = new FootballManagerModel();
        Parser.loadDatabase(model);
        FootballManagerView view = new FootballManagerView();

        FXMLLoader uiLoader = new FXMLLoader(getClass().getResource("ui.fxml"));
        uiLoader.setController(view);
        primaryStage.setScene(new Scene(uiLoader.load(), 800, 600));
        primaryStage.setTitle("Football Manager");
        primaryStage.show();

        FXFootballManagerController controller = new FXFootballManagerController(model, view);
        controller.executa();
    }
}
