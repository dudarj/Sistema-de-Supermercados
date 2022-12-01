package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Cliente;
import model.DTO.Item;
import model.DTO.Produto;
import model.DTO.Venda;
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
    private TableColumn<Produto, Integer> tbcEstoqueVenda;
    @FXML
    private TableColumn<String, String> tbcQuantidadeVenda;
    @FXML
    private TableColumn<Produto, String> tbcQtde;
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
    @FXML
    private Button btnFinalizarCompra;

    private ProdutoServico servico = new ProdutoServico();

    private Cliente cliente = new Cliente();

    private ObservableList<Produto> obLista;
    private ObservableList<Produto> obListaVenda;

    Set<Produto> listaProduto = new HashSet<>();

    Set<Item> itens = new HashSet<>();
    List<Venda> venda = new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void onFinalizarComprasAction(ActionEvent event) {/*Finalizar a venda para o cliente.*/
        Date dataVenda = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        Alerts.showConfirmation("horas", sdf.format(dataVenda)); //08000244323 - Jeniffer;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        AdicionarItemsTableview();
        initializeNodes();
        initializeNodesVenda();
    }

    private void initializeNodes() {
        tbcItemVenda.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcPrecoVenda.setCellValueFactory(new PropertyValueFactory<>("preco"));
        Utils.formatTableColumnDouble(tbcPrecoVenda, 2);
        tbcEstoqueVenda.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvLoja.prefHeightProperty().bind(stage.heightProperty());
    }

    private void initializeNodesVenda() {
        tbcItemCompra.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcPrecoCompra.setCellValueFactory(new PropertyValueFactory<>("preco"));
        Utils.formatTableColumnDouble(tbcPrecoCompra, 2);
        tbcQuantidadeVenda.setCellValueFactory(new PropertyValueFactory<>("qtdeItem"));

        tbvCompra.setEditable(true);
        tbcQuantidadeVenda.setCellFactory(TextFieldTableCell.forTableColumn());

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvCompra.prefHeightProperty().bind(stage.heightProperty());

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

    public void AdicionarItemsTableview() {

        obListaVenda = FXCollections.observableArrayList(listaProduto);
        tbvCompra.setItems(obListaVenda);

        initRemoveButtons();
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
        AdicionarItemsTableview();
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

                    popularLista(obj); // metodo para adicionar produtos a lista

                });
            }

        });
    }

    private void initRemoveButtons() {
        tbcREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcREMOVE.setCellFactory(param -> new TableCell<Produto, Produto>() {
            private final Button button = new Button("Remover");

            @Override
            protected void updateItem(Produto obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> {

                    Produto p = tbvCompra.getSelectionModel().getSelectedItem();
                    if (p != null) {
                        Optional<ButtonType> result;
                        result = Alerts.showConfirmation("Deseja realmente retirar da lista de compra",
                                p.getDescricao());
                        if (result.get() == ButtonType.OK) {
                            listaProduto.remove(p);
                            obListaVenda.remove(p);
                        }

                    }

                });
            }
        });
    }

    // Adiciona itens a lista de produtos.
    public void popularLista(Produto obj) {
        listaProduto.add(obj);
        AdicionarItemsTableview();
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
    public void onquantidadeCompra(@SuppressWarnings("rawtypes") CellEditEvent editEvent) {

        Produto produto = tbvCompra.getSelectionModel().getSelectedItem();
        String q = (String) editEvent.getNewValue();
        produto.setQtdeItem(Integer.parseInt(q));
        System.out.println(produto);

    }

}
