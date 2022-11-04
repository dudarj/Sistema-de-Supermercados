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
import javafx.stage.Stage;
import model.DTO.Cliente;
import model.servicos.ClienteServico;
import util.Alerts;
import util.Utils;

public class LoginViewController implements Initializable {

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    private Button btnLogar;

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
                loadView("/view/TelaMenuFuncionarioView.fxml", parentStage);
            } else if (loginInput.equals(c.getLogin()) && (senhaInput.equals(c.getSenha())) && (c.getTipo().equals("c"))) {
                Stage parentStage = Utils.currentStage(event);
                loadView("/view/TelaMenuClienteView.fxml", parentStage);
            } else {
                Alerts.showAlert("Autenticação", "Acesso Negado", "Informações não registradas.", Alert.AlertType.WARNING);
            }
        } else {
            Alerts.showAlert("Autenticação", "Acesso Negado", "Informações não registradas.", Alert.AlertType.WARNING);
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
