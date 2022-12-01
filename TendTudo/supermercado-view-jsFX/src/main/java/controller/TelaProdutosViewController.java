package controller;

import conexao.DbException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import listeners.DataChangeListener;
import model.DTO.Produto;
import model.exceptions.ValidationException;
import model.servicos.ProdutoServico;
import util.Alerts;
import util.MaskFieldUtil;
import util.Utils;

public class TelaProdutosViewController implements Initializable {

    @FXML
    private TextField codigo;

    @FXML
    private TextField descricao;

    @FXML
    private TextField preco;

    @FXML
    private TextField quantidade;
    
    @FXML
    private TextField imagem;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCancelar;

    private Produto entidade;
    
    private ProdutoServico servico;

    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    public void setEntidade(Produto entidade) {
        this.entidade = entidade;
    }

    public void setServico(ProdutoServico servico) {
        this.servico = servico;
    }

    public void subscribeDataChangeListener(DataChangeListener listener) {
        dataChangeListeners.add(listener);
    }

    @FXML
    public void onBtnAdicionaAction(ActionEvent event) {
        try {

            entidade = obterDadosFormulario();

            if (entidade == null) {
                throw new IllegalStateException("A Entidade não pode estar nula");
            }

            servico = new ProdutoServico();
            servico.salvar(entidade);

            if (servico == null) {
                throw new IllegalStateException("Serviço nulo");
            }
            notifyDataChangeListeners();

            Utils.currentStage(event).close();
        } catch (DbException e) {
            Alerts.showAlert("Erro ao salvar objeto", null, e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    public void onBtnCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    private Produto obterDadosFormulario() {
        Produto obj = new Produto();

        ValidationException exception = new ValidationException("Validação de erro");

        obj.setCodigo(Utils.tryParseToLong(codigo.getText()));

        if (descricao.getText() == null || descricao.getText().trim().equals("")) {
            exception.addError("descricao", "O campo não pode estar vazio.");
        }
        obj.setDescricao(descricao.getText());
        
        if (imagem.getText() == null || imagem.getText().trim().equals("")) {
            exception.addError("imagem", "O campo não pode estar vazio.");
        }
        obj.setImg(imagem.getText());

        if (preco.getText() == null || preco.getText().trim().equals("")) {
            exception.addError("preco", "O campo não pode estar vazio.");
        }
        obj.setPreco(Utils.tryParseToDouble(preco.getText()));

        if (quantidade.getText() == null || quantidade.getText().trim().equals("")) {
            exception.addError("quantidade", "O campo não pode estar vazio.");
        }
        obj.setQuantidade(Utils.tryParseToInt(quantidade.getText()));

        if (exception.getErrors().size() > 0) {
            throw exception;
        }

        return obj;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        MaskFieldUtil.numericField(quantidade);
        MaskFieldUtil.numericField(preco);
        MaskFieldUtil.monetaryField(preco);
    }

    private void notifyDataChangeListeners() {
        for (DataChangeListener listener : dataChangeListeners) {
            listener.onDataChanged();
        }
    }

    public void updateFormData() {
        if (entidade == null) {
            throw new IllegalStateException("Entidade não pode estar nula");
        }
        codigo.setText(String.valueOf(entidade.getCodigo()));
        descricao.setText(entidade.getDescricao());
        preco.setText(String.valueOf(entidade.getPreco()));
        quantidade.setText(String.valueOf(entidade.getQuantidade()));
        imagem.setText(entidade.getImg());
        
        initializeNodes();
    }

}
