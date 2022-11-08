package controller;

import application.Main;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Produto;
import model.servicos.ProdutoServico;
import util.Utils;

public class TelaClienteSupermercadoViewController implements Initializable, DataChangeListener {

    @FXML
    private TableView<Produto> tbvLoja;

    @FXML
    private TableView<Produto> tbvCompra;

    @FXML
    private TableColumn<Produto, String> tbcItemVenda;
    @FXML
    private TableColumn<Produto, String> tbcItemCompra;

    @FXML
    private TableColumn<Produto, Double> tbcPrecoVenda;
    @FXML
    private TableColumn<Produto, Double> tbcPrecoCompra;

    @FXML
    private TableColumn<Produto, String> tbcEstoqueVenda;

    @FXML
    private TableColumn<Integer, Integer> tbcQuantidadeVenda;

    @FXML
    private TableColumn<Produto, Integer> tbcQuantidadeCompra;

    @FXML
    private TableColumn<Produto, Produto> tbcADICIONA;
    @FXML
    private TableColumn<Produto, Produto> tbcREMOVE;

    @FXML
    private TextField pesquisa;
    @FXML
    private Button btnpesquisar;

    private ProdutoServico servico = new ProdutoServico();
    private ObservableList<Produto> obLista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        initializeNodes();
    }

    private void initializeNodes() {
        tbcItemVenda.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcPrecoVenda.setCellValueFactory(new PropertyValueFactory<>("preco"));
        Utils.formatTableColumnDouble(tbcPrecoVenda, 2);
        tbcEstoqueVenda.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        /*TableColumn qtde = new TableColumn("qtdeItem");
        qtde.setCellFactory(TextFieldTableCell.forTableColumn());
        qtde.setCellFactory(new PropertyValueFactory(tbcQuantidadeVenda));*/
        
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvLoja.prefHeightProperty().bind(stage.heightProperty());
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("Servico é nulo");
        }
        List<Produto> list = servico.ListarProdutos();
        obLista = FXCollections.observableArrayList(list);
        tbvLoja.setItems(obLista);
        initAdicionaBotao();
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }


    private void initAdicionaBotao() {

        tbcADICIONA.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcADICIONA.setCellFactory(param -> new TableCell<Produto, Produto>() {
            private final Button button = new Button("Adicionar ao Carrinho");

            @Override
            protected void updateItem(Produto obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
            }
        });
    }

    @FXML
    public void onbtnPesquisarAction(ActionEvent event) {
        List<Produto> objList;

        if (pesquisa.getText() == " ") {
            objList = servico.findAll();
        } else {
            objList = servico.findByNome(pesquisa.getText());

        }

        ObservableList<Produto> list;
        list = FXCollections.observableArrayList(objList);
        tbvLoja.setItems(list);
    }
    
    
}
