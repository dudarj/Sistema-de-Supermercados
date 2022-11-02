module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires SupermercadoNegocio;
    
    opens controller to javafx.fxml;
    exports application;
}
