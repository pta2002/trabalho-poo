import controller.FXFootballManagerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FootballManagerModel;
import model.LinhaIncorretaException;
import model.Parser;
import view.FXFootballManagerView;

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
        FXFootballManagerView view = new FXFootballManagerView();

        FXMLLoader uiLoader = new FXMLLoader(getClass().getResource("ui.fxml"));
        uiLoader.setController(view);
        primaryStage.setScene(new Scene(uiLoader.load(), 1280, 728));
        primaryStage.setTitle("Football Manager");
        primaryStage.show();

        FXFootballManagerController controller = new FXFootballManagerController(model, view);
        controller.executa();
    }
}
