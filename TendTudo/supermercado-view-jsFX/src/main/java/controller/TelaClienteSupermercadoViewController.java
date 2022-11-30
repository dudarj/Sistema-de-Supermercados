package controller;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import application.Main;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Produto;
import model.servicos.ProdutoServico;
import util.Alerts;
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
    private TableColumn<String, String> tbcQuantidadeVenda;

    @FXML
    private TableColumn<Produto, String> tbcQuantidadeCompra;

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
    private ObservableList<Produto> obListaVenda;
    Set<Produto> listaProduto = new HashSet<>();

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
        //tbcQuantidadeCompra.setCellValueFactory(new PropertyValueFactory<>("qtdeItem"));

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
        //  tbcQuantidadeCompra.setCellFactory(TextFieldTableCell.forTableColumn());
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
                button.setOnAction(event -> {

                    popularLista(obj); //metodo para adicionar produtos a lista

                });
            }
        });
    }

    //Adiciona itens a lista de produtos.
    public void popularLista(Produto obj) {
        listaProduto.add(obj);
        AdicionarItemsTableview();
    }

    @FXML
    public void deletarProdutoItems(MouseEvent e) {

        int x = tbvCompra.getSelectionModel().getSelectedIndex();
        Produto p = (Produto) tbvCompra.getItems().get(x);
        System.out.println("Produto" + p.getDescricao());
        if (x > -1) {
            Optional<ButtonType> result;
            result = Alerts.showConfirmation("Deseja realmente retirar da lista de compra", p.getDescricao());
            if (result.get() == ButtonType.OK) {
                obListaVenda.remove(x);
            }
        }

    }

    public void AdicionarItemsTableview() {
        listaProduto.forEach(System.out::println);

        tbcItemCompra.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcPrecoCompra.setCellValueFactory(new PropertyValueFactory<>("preco"));
        //tbcQuantidadeCompra.setCellValueFactory(new PropertyValueFactory<>("qtdeItem"));

        obListaVenda = FXCollections.observableArrayList(listaProduto);
        tbvCompra.setItems(obListaVenda);
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

    @FXML
    public void onquantidadeCompra(TableColumn.CellEditEvent<Produto, String> prod) {
        Produto p = tbvLoja.getSelectionModel().getSelectedItem();
        p.setQtdeItem(Integer.parseInt(prod.getNewValue()));

        if ((p.getQuantidade() < p.getQtdeItem()) || (p.getQuantidade() == 0)) {
            p.setQtdeItem(0);
            Alerts.showAlert("Estoque", "Estoque Insuficiente", "Não existe produto o suficiente em estoque.", Alert.AlertType.INFORMATION);
        }
    }

}
