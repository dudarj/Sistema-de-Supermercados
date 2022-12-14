/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DTO.Cliente;
import util.Alerts;
import util.Utils;

public class TelaMenuGerenciaViewController implements Initializable {

    @FXML
    private Button btnTabelacliente;

    @FXML
    private Button btnTabelaprodutos;
    
    @FXML
    private Button btnTabelavendas;
    
    @FXML
    private Button btnTabelapagamento;
    
    
    private Cliente cliente = new Cliente();
    
    public Cliente getCliente() {
    	return cliente;
    }
    
    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    }
    

    @FXML
    public void onCaminhoClienteAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/ListaClientesView.fxml", parentStage);
    }

    @FXML
    public void onCaminhoProdutosAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/ListaProdutosView.fxml", parentStage);
    }
    
    @FXML
    public void onCaminhoVendasAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/ListaVendasView.fxml", parentStage);
    }
    
    @FXML
    public void onCaminhoPagamentoAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        loadView("/view/ListaPagamentoView.fxml", parentStage);
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
            Alerts.showAlert("Exce????o de entrada e sa??da", "Erro ao carregar a Tela", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}