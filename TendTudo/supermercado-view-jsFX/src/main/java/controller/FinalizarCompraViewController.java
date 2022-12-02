package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import util.Utils;

public class FinalizarCompraViewController implements Initializable {

    @FXML
    private Button btnFinalizarCompra;
    @FXML
    private Button btnCancelar;

    @FXML
    public void onBtnCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
