package controller;

import application.Main;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import listeners.DataChangeListener;
import model.DTO.Cliente;
import model.servicos.ClienteServico;


public class ListaClientesViewController implements Initializable, DataChangeListener {
    
    
    @FXML
    private TableView<Cliente> tbvCliente;
    
    @FXML
    private TableColumn<Cliente, Integer> tbcCodigo;
    
    @FXML
    private TableColumn<Cliente, String> tbcNome;

    @FXML
    private TableColumn<Cliente, String> tbcCpf;

    @FXML
    private TableColumn<Cliente, String> tbcTelefone;

    @FXML
    private TableColumn<Cliente, String> tbcEndereco;

    @FXML
    private TableColumn<Cliente, Integer> tbcStatus;

    @FXML
    private TableColumn<Cliente, String> tbcTipo;
    
    @FXML
    private TextField pesquisa;

    @FXML
    private Button btnpesquisar;

    private ClienteServico servico = new ClienteServico();
    private ObservableList<Cliente> obLista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlterarTabelaVisualizacao();
        initializeNodes();
    }

    private void initializeNodes() {
        tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tbcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tbcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tbvCliente.prefHeightProperty().bind(stage.heightProperty());
    }

    public void AlterarTabelaVisualizacao() {
        if (servico == null) {
            throw new IllegalStateException("O serviço é nulo.");
        }
        List<Cliente> list = servico.ListarClientes();
        obLista = FXCollections.observableArrayList(list);
        tbvCliente.setItems(obLista);
    }

    @Override
    public void onDataChanged() {
        AlterarTabelaVisualizacao();
    }
    
    @FXML
    public void onbtnPesquisarAction(ActionEvent event) {

        List<Cliente> objList;
        if (pesquisa.getText() == " ") {
            objList = servico.findAll();
        } else {
            objList = servico.findByNome(pesquisa.getText());
        }
        ObservableList<Cliente> list;
        list = FXCollections.observableArrayList(objList);
        tbvCliente.setItems(list);

    }
}