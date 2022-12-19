module com.example.javafxsandbox {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxsandbox to javafx.fxml;
    exports com.example.javafxsandbox;
}