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
import model.DTO.TipoPagamento;
import model.exceptions.ValidationException;
import model.servicos.TipoPagamentoServico;
import util.Alerts;
import util.Utils;

public class TelaPagamentoViewController implements Initializable {

    @FXML
    private TextField codigo;

    @FXML
    private TextField descricao;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCancelar;

    private TipoPagamento entidade;
    private TipoPagamentoServico servico;

    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    public void setEntidade(TipoPagamento entidade) {
        this.entidade = entidade;
    }

    public void setServico(TipoPagamentoServico servico) {
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

            servico = new TipoPagamentoServico();
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

    private TipoPagamento obterDadosFormulario() {
        TipoPagamento obj = new TipoPagamento();

        ValidationException exception = new ValidationException("Validação de erro");

        obj.setCodigo(Utils.tryParseToLong(codigo.getText()));

        if (descricao.getText() == null || descricao.getText().trim().equals("")) {
            exception.addError("descricao", "O campo não pode estar vazio.");
        }
        obj.setDescricao(descricao.getText());

        if (exception.getErrors().size() > 0) {
            throw exception;
        }

        return obj;
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
