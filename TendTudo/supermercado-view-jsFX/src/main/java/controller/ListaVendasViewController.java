package controller;

import application.Main;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Cliente;
import model.DTO.Pagamento;
import model.DTO.TipoPagamento;
import model.DTO.Venda;
import model.servicos.VendaServico;
import util.Utils;

public class ListaVendasViewController implements Initializable, DataChangeListener {

    @FXML
    private TableView<Venda> tbvVenda;

    @FXML
    private TableColumn<Venda, Long> tbcCodigo;

    @FXML
    private TableColumn<Venda, String> tbcCliente;

    @FXML
    private TableColumn<Venda, Date> tbcData;

    @FXML
    private TableColumn<Venda, Double> tbcValorTotal;

    @FXML
    private TableColumn<TipoPagamento, Venda> tbcTipoPagamento;

    @FXML
    private TableColumn<Pagamento, Venda> tbcParcelas;

    private VendaServico servico = new VendaServico();
    private ObservableList<Venda> obLista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        initializeNodes();
    }
    
    private void initializeNodes() {
        tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tbcCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcData.setCellValueFactory(new PropertyValueFactory<>("dataVenda"));
        Utils.formatTableColumnDate(tbcData, "dd/MM/yyyy");
        tbcValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        Utils.formatTableColumnDouble(tbcValorTotal, 2);
        tbcTipoPagamento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcParcelas.setCellValueFactory(new PropertyValueFactory<>("parcelas"));

        
        
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvVenda.prefHeightProperty().bind(stage.heightProperty());
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("O serviço é nulo.");
        }
        List<Venda> list = servico.ListarVendas();
        obLista = FXCollections.observableArrayList(list);
        tbvVenda.setItems(obLista);
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }

}
