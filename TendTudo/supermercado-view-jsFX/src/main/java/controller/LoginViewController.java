package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Alerts;
import util.Utils;

public class LoginViewController implements Initializable {
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField senha;
    
    @FXML
    private Button btnLogar;
    
    //private ClienteServico servico = new ClienteServico();

    
    @FXML
    public void onCaminhoLogarAction(ActionEvent event) {

        String loginInput = login.getText();
        String senhaInput = senha.getText();

        //Cliente c = servico.findByLogin(loginInput);

       if (loginInput == "") {
            System.out.println("Usuário não encontrado.");
            return;
        }
        if (loginInput == "admin" && senhaInput == "123") {
            Stage parentStage = Utils.currentStage(event);
            loadView("/view/TelaMenuFuncionarioView.fxml", parentStage);
        } else {
             Stage parentStage = Utils.currentStage(event);
            loadView("/view/TelaMenuClienteView.fxml", parentStage);
        } 
       
    }

    private void loadView(String absoluteName, Stage parentStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.show();
            //dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("Exceção de entrada e saída", "Erro ao carregar a Tela", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
