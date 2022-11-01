package controller;

import application.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import util.Alerts;



public class MainViewController implements Initializable {

    @FXML
    private Button btnLogin;
    
    @FXML
    public void onCaminhoLogarAction() {
        loadView("/view/LoginVendedorView.fxml", x -> {
		});
    }
    
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			AnchorPane  newAnchorPane  = loader.load();

			Scene mainScene = Main.getMainScene();
                        AnchorPane mainAnchorPane  = (AnchorPane ) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainAnchorPane .getChildren().get(0);
			mainAnchorPane.getChildren().clear();
			mainAnchorPane.getChildren().add(mainMenu);
			mainAnchorPane.getChildren().addAll(newAnchorPane.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);
		} catch (IOException e) {
			Alerts.showAlert("Exceção de entrada e saída", "Erro ao carregar a Tela", e.getMessage(), AlertType.ERROR);
		}
	}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
