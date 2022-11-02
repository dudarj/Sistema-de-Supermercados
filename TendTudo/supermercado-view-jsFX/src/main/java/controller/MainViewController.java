package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Alerts;
import util.Utils;

public class MainViewController implements Initializable {

    @FXML
    private Button btnGerencia;

    @FXML
    private Button btnCliente;

    @FXML
    public void onCaminhoGerenciaAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/LoginView.fxml", parentStage);
    }

    @FXML
    public void onCaminhoClienteAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/CadastroClienteView.fxml", parentStage);
    }

    private void loadView(String absoluteName, Stage parentStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("Exceção de entrada e saída", "Erro ao carregar a Tela", e.getMessage(), AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
