package controller;

import application.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Produto, Integer> tbcQuantidadeCompra;

    @FXML
    private TableColumn<Produto, Produto> tbcADICIONA;
    @FXML
    private TableColumn<Produto, Produto> tbcREMOVE;

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
        //initAdicionaBotao();
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }

    private void populaTabelaCompra() {

    }

    /*private void initAdicionaBotao() {

        tbcADICIONA.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcADICIONA.setCellFactory(param -> new TableCell<Produto, Produto>() {
            private final Button button = new Button("+");

            @Override
            protected void updateItem(Produto obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> );
            }
        });
    }*/
}
