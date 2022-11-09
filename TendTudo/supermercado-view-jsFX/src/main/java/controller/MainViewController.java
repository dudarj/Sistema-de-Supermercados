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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DTO.Cliente;
import model.servicos.ClienteServico;
import util.Alerts;
import util.Utils;

public class MainViewController implements Initializable {

    @FXML
    private Button btnLogar;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;
    
     private ClienteServico servico = new ClienteServico();
     
    @FXML
    public void onCaminhoLogarAction(ActionEvent event) {
        String loginInput = login.getText().trim();
        String senhaInput = senha.getText().trim();

        Cliente c = servico.findByLogin(loginInput);

        if (loginInput.equals("")) {
            Alerts.showAlert("Autenticação", "Acesso", "Campos de preenchimento obrigatórios.", Alert.AlertType.WARNING);
            System.out.println("Usuário não encontrado.");
            return;
        }
        if (c != null) {
            if (loginInput.equals(c.getLogin()) && (senhaInput.equals(c.getSenha())) && (c.getTipo().equals("g"))) {
                Stage parentStage = Utils.currentStage(event);
                login.setText("");
                senha.setText("");
                loadView("/view/TelaMenuGerenciaView.fxml", parentStage);
            } else if (loginInput.equals(c.getLogin()) && (senhaInput.equals(c.getSenha())) && (c.getTipo().equals("c"))) {
                Stage parentStage = Utils.currentStage(event);
                login.setText("");
                senha.setText("");
                loadView("/view/TelaClienteSupermercadoView.fxml", parentStage);
            } else {
                Alerts.showAlert("Autenticação", "Acesso Negado", "Informações não registradas.", Alert.AlertType.WARNING);
            }
        } else {
            Alerts.showAlert("Autenticação", "Acesso Negado", "Informações não registradas.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void onCaminhoCadastrarAction(ActionEvent event) {
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
        //TODO
    }
}
