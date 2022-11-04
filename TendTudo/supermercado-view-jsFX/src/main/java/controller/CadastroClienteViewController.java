package controller;

import conexao.DbException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DTO.Cliente;
import model.exceptions.ValidationException;
import model.servicos.ClienteServico;
import util.Alerts;
import util.Utils;

public class CadastroClienteViewController implements Initializable {

    @FXML
    private TextField nome;

    @FXML
    private TextField telefone;

    @FXML
    private TextField endereco;

    @FXML
    private TextField cpf;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnLogin;

    private Cliente entidade;
    private ClienteServico servico;

    public void setCliente(Cliente entidade) {
        this.entidade = entidade;
    }

    public void setServicos(ClienteServico servico) {
        this.servico = servico;
    }

    @FXML
    public void onCaminhoCadastrarAction(ActionEvent event) {
        if (entidade == null) {
            throw new IllegalStateException("A entidade é nula");
        }

        if (servico == null) {
            throw new IllegalStateException("O serviço é nulo");
        }

        try {
            entidade = retornaDadosDeFormulario();
            servico.cadastrar(entidade);
            Utils.currentStage(event).close();
        } catch (DbException e) {
            Alerts.showAlert("Erro ao salvar objeto", null, e.getMessage(), AlertType.ERROR);
        }

    }

    private Cliente retornaDadosDeFormulario() {

        Cliente obj = new Cliente();
        ValidationException exception = new ValidationException("Validation error");

        if (nome.getText() == null || nome.getText().trim().equals("")) {
            exception.addError("nome", "O campo não pode estar vazio.");
        }
        obj.setNome(nome.getText());

        if (telefone.getText() == null || telefone.getText().trim().equals("")) {
            exception.addError("telefone", "O campo não pode estar vazio.");
        }
        obj.setTelefone(telefone.getText());

        if (endereco.getText() == null || endereco.getText().trim().equals("")) {
            exception.addError("endereco", "O campo não pode estar vazio.");
        }
        obj.setEndereco(endereco.getText());

        if (cpf.getText() == null || cpf.getText().trim().equals("")) {
            exception.addError("cpf", "O campo não pode estar vazio.");
        }
        obj.setCpf(cpf.getText());

        if (login.getText() == null || login.getText().trim().equals("")) {
            exception.addError("login", "O campo não pode estar vazio.");
        }
        obj.setLogin(login.getText());

        if (senha.getText() == null || senha.getText().trim().equals("")) {
            exception.addError("senha", "O campo não pode estar vazio.");
        }
        obj.setSenha(senha.getText());

        return obj;
    }

    @FXML
    public void onCaminhoLogarAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/LoginView.fxml", parentStage);
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
