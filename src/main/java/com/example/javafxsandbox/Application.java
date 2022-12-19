package com.example.javafxsandbox;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Scene startScene = new Scene(root);


        stage.setTitle("JavaFX Sandbox!");
        stage.getIcons().add(new Image("icon.png"));


        stage.setScene(startScene);
        stage.show();
    }
}