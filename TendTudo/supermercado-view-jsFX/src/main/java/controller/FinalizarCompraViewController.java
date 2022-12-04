package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DTO.Cliente;
import model.DTO.Produto;
import model.DTO.TipoPagamento;
import model.DTO.Venda;
import util.Alerts;
import util.Utils;

public class FinalizarCompraViewController implements Initializable {
    
    public FinalizarCompraViewController() {
        
    }

    @FXML
    private Button btnFinalizarCompra;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblCliente;
    @FXML
    private Label lblDataHora;
    @FXML
    private Label lblValorTotal;
    @FXML
    private Label lblTipoPagamento;
    @FXML
    private TableView<Produto> tbvCarrinho;
    
    @FXML
    private TableColumn<Produto, String> tbcProduto;
    @FXML
    private TableColumn<Produto, String> tbcQtde;
    
    
    private Cliente cliente = new Cliente();
    
    public Cliente getCliente() {
    	return cliente;
    }
    
    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    }
    
    private Venda venda = new Venda();
    
    public Venda getVenda() {
    	return venda;
    }
    
    public void setVenda(Venda venda) {
    	this.venda = venda;
    }
    
    private TipoPagamento tipopagamento = new TipoPagamento();

    public TipoPagamento getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(TipoPagamento tipopagamento) {
        this.tipopagamento = tipopagamento;
    }
    
    

    @FXML
    public void onBtnCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }
    
    @FXML
    private Label label1 = new Label(cliente.getNome());


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Alerts.showConfirmation("teste", cliente.getNome());
        System.out.println(cliente.getNome());
        lblCliente.setText(cliente.getNome());
        /*label1.setMnemonicParsing(true);
        lblTipoPagamento.setLabelFor(label1);*/
    }

}