package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class FXSimulacaoView {
    private FXMLLoader loader;
    private Stage popUp;

    public FXSimulacaoView() {
        loader = new FXMLLoader(getClass().getResource("/simulacao.fxml"));
        loader.setController(this);

        popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setTitle("Simulação");
    }

    public void mostra() throws IOException {
        popUp.setScene(new Scene(loader.load()));
        popUp.show();
    }
}
