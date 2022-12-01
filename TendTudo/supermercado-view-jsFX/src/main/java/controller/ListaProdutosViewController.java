package controller;

import application.Main;
import conexao.DbIntegrityException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Produto;
import model.servicos.ProdutoServico;
import util.Alerts;
import util.Utils;

public class ListaProdutosViewController implements Initializable, DataChangeListener {

    @FXML
    private Button btnNovoProduto;

    @FXML
    private TableView<Produto> tbvProduto;

    @FXML
    private TableColumn<Produto, Integer> tbcCodigo;

    @FXML
    private TableColumn<Produto, String> tbcDescricao;

    @FXML
    private TableColumn<Produto, Double> tbcPreco;

    @FXML
    private TableColumn<Produto, Integer> tbcQuantidade;

    @FXML
    private TableColumn<Produto, String> tbcImg;

    @FXML
    private TableColumn<Produto, Produto> tbcEDIT;

    @FXML
    private TableColumn<Produto, Produto> tbcREMOVE;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button btnpesquisar;

    private ProdutoServico servico = new ProdutoServico();
    private ObservableList<Produto> obLista;

    @FXML
    public void onBtnNovoProdutoAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        Produto obj = new Produto();
        loadView(obj, "/view/TelaProdutosView.fxml", parentStage);
    }

    private void loadView(Produto obj, String absoluteName, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            TelaProdutosViewController controller = loader.getController();
            controller.setEntidade(obj);
            controller.setServico(new ProdutoServico());
            controller.subscribeDataChangeListener(this);
            controller.updateFormData();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Produtos");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("Excessão de entrada e Saída", "Erro ao carregamento da tela", e.getMessage(), AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        initializeNodes();
    }

    private void initializeNodes() {
        tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        Utils.formatTableColumnDouble(tbcPreco, 2);
        tbcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tbcImg.setCellValueFactory(new PropertyValueFactory<>("url_img"));
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvProduto.prefHeightProperty().bind(stage.heightProperty());
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("Serviço é nulo");
        }
        List<Produto> list = servico.ListarProdutos();
        obLista = FXCollections.observableArrayList(list);
        tbvProduto.setItems(obLista);
        initEditaBotao();
        initRemoveBotao();
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }

    private void initEditaBotao() {
        tbcEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcEDIT.setCellFactory(param -> new TableCell<Produto, Produto>() {
            private final Button button = new Button("Editar");

            @Override
            protected void updateItem(Produto obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> loadView(obj, "/view/TelaProdutosView.fxml", Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveBotao() {
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
                button.setOnAction(event -> removeEntity(obj));
            }
        });
    }

    private void removeEntity(Produto obj) {
        Optional<ButtonType> result = Alerts.showConfirmation("Confimação", "Deseja realmente deletar?");

        if (result.get() == ButtonType.OK) {
            if (servico == null) {
                throw new IllegalStateException("Serviço Nulo");
            }
            try {
                servico.remove(obj);
                AlterarTabelaVisualizacao();
            } catch (DbIntegrityException e) {
                Alerts.showAlert("Erro ao remover objeto", null, e.getMessage(), AlertType.ERROR);
            }
        }
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
        tbvProduto.setItems(list);

    }

}
