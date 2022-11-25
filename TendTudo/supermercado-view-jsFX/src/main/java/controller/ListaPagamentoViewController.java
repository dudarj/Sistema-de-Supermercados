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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.TipoPagamento;
import model.servicos.TipoPagamentoServico;
import util.Alerts;
import util.Utils;

public class ListaPagamentoViewController implements Initializable, DataChangeListener {

    @FXML
    private Button btnNovoTipoPagamento;

    @FXML
    private TableView<TipoPagamento> tbvPagamento;

    @FXML
    private TableColumn<TipoPagamento, Integer> tbcCodigo;

    @FXML
    private TableColumn<TipoPagamento, String> tbcDescricao;

    @FXML
    private TableColumn<TipoPagamento, TipoPagamento> tbcEDIT;

    @FXML
    private TableColumn<TipoPagamento, TipoPagamento> tbcREMOVE;

    private TipoPagamentoServico servico = new TipoPagamentoServico();
    private ObservableList<TipoPagamento> obLista;

    @FXML
    public void onBtnNovoTipoPagamentoAction(ActionEvent event) {
        Stage parentStage = Utils.currentStage(event);
        TipoPagamento obj = new TipoPagamento();
        loadView(obj, "/view/TelaPagamentoView.fxml", parentStage);
    }

    private void loadView(TipoPagamento obj, String absoluteName, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            TelaPagamentoViewController controller = loader.getController();
            controller.setEntidade(obj);
            controller.setServico(new TipoPagamentoServico());
            controller.subscribeDataChangeListener(this);
            controller.updateFormData();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Pagamento");
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
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvPagamento.prefHeightProperty().bind(stage.heightProperty());
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("Serviço é nulo");
        }
        List<TipoPagamento> list = servico.ListarTiposPagamentos();
        obLista = FXCollections.observableArrayList(list);
        tbvPagamento.setItems(obLista);
        initEditaBotao();
        initRemoveBotao();
    }

    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }

    private void initEditaBotao() {
        tbcEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcEDIT.setCellFactory(param -> new TableCell<TipoPagamento, TipoPagamento>() {
            private final Button button = new Button("Editar");

            @Override
            protected void updateItem(TipoPagamento obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> loadView(obj, "/view/TelaPagamentoView.fxml", Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveBotao() {
        tbcREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tbcREMOVE.setCellFactory(param -> new TableCell<TipoPagamento, TipoPagamento>() {
            private final Button button = new Button("Remover");

            @Override
            protected void updateItem(TipoPagamento obj, boolean empty) {
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

    private void removeEntity(TipoPagamento obj) {
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

}
