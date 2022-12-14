package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import listeners.DataChangeListener;
import model.DTO.Cliente;
import model.DTO.Item;
import model.DTO.Produto;
import model.DTO.TipoPagamento;
import model.DTO.Venda;
import model.servicos.ItemServico;
import model.servicos.ProdutoServico;
import model.servicos.TipoPagamentoServico;
import model.servicos.VendaServico;
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
    private TableColumn<Produto, Produto> tbcADICIONA;
    @FXML
    private TableColumn<Produto, Produto> tbcREMOVE;
    @FXML
    private ComboBox<TipoPagamento> comboBoxTipo;
    @FXML
    private TextField parcelas;
    @FXML
    private TextField pesquisa;
    @FXML
    private Button btnpesquisar;
    @FXML
    private Button btnFinalizarCompra;
    @FXML
    private Button btnAdicionaTipoPagamento;

    private ProdutoServico servico = new ProdutoServico();
    private TipoPagamentoServico servicoTipo = new TipoPagamentoServico();

    private Cliente cliente = new Cliente();
    private Venda v = new Venda();
    private TipoPagamento tipopagamento = new TipoPagamento();

    private VendaServico vendaServico = new VendaServico();

    private ObservableList<Produto> obLista;
    private ObservableList<Produto> obListaVenda;
    private ObservableList<TipoPagamento> obsListTipo;

    Set<Produto> listaProduto = new HashSet<>();
    Set<Item> itens = new HashSet<>();
    List<Venda> venda = new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void onFinalizarComprasAction(ActionEvent event) {
        Double totalVenda;

        totalVenda = somarValorTotalItens();

        Date dataVenda = new Date();

        v.setCliente(cliente);
        v.setDataVenda(dataVenda);

        v.setValorTotal(totalVenda);
        v.setTotal(totalVenda);

        Alerts.showConfirmation("Valor Total", "Valor Total: " + v.getValorTotal().toString());

        vendaServico.salvar(v, cliente.getCodigo());

        populaItensProdutoVenda(listaProduto, v);

        ItemServico itemServico = new ItemServico();

        itemServico.insert(itens);

        Alerts.showAlert("Opera????o", "Compra", "Compra realizada com sucesso!", AlertType.INFORMATION);;
        /*Stage parentStage = Utils.currentStage(event);
    	
        loadView(cliente, "/view/FinalizarCompraView.fxml", parentStage);*/
    }

    public void populaItensProdutoVenda(Set<Produto> produtosItens, Venda v) {
        Item i = new Item();

        for (Produto p : produtosItens) {
            i.setProduto(p);
            i.setVenda(v);
            i.setPreco(p.getPreco());
            i.setQuantidade(p.getQtdeItem());
            i.setValorTotal(p.getPreco() * p.getQtdeItem());

            itens.add(i);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        AdicionarItemsTableview();
        initializeNodes();
        initializeComboBoxTipo();
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

    private void initializeComboBoxTipo() {
        Callback<ListView<TipoPagamento>, ListCell<TipoPagamento>> factory = lv -> new ListCell<TipoPagamento>() {
            @Override
            protected void updateItem(TipoPagamento tipo, boolean empty) {
                super.updateItem(tipo, empty);
                setText(empty ? "" : tipo.getDescricao());
            }
        };
        comboBoxTipo.setCellFactory(factory);
        comboBoxTipo.setButtonCell(factory.call(null));
    }

    public void loadAssociatedObjectsTipo() {
        if (servicoTipo == null) {
            throw new IllegalStateException("tipo servico nulo");
        }
        List<TipoPagamento> list = servicoTipo.ListarTiposPagamentos();
        obsListTipo = FXCollections.observableArrayList(list);
        comboBoxTipo.setItems(obsListTipo);
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("Servico ?? nulo");
        }
        List<Produto> list = servico.ListarProdutos();
        obLista = FXCollections.observableArrayList(list);
        tbvLoja.setItems(obLista);

        initAdicionaBotao();
    }

    protected Double somarValorTotalItens() {
        Double vl = 0.0;

        for (Produto items : listaProduto) {
            vl += items.getPreco() * items.getQtdeItem();
        }

        return vl;
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
        //somarValorTotalItens();

    }

    private void loadView(Cliente obj, String absoluteName, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            FinalizarCompraViewController fin = loader.getController();
            fin.setCliente(obj);

            Stage dialogStage = new Stage();
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.setTitle("Finalizar Compra");
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("Exce????o de entrada e sa??da", "Erro ao carregar a Tela", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
