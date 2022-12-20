module com.example.javafxsandbox {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.swing;


    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens StartUpApplication to javafx.fxml;
    exports StartUpApplication;
    exports Paint;
    opens Paint to javafx.fxml;
}