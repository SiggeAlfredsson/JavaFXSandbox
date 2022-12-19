package com.example.javafxsandbox;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

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
        stage.setResizable(false);

        /*

        Media media = new Media("file:///Movies/test.mp3"); //replace /Movies/test.mp3 with your file
        MediaPlayer player = new MediaPlayer(media);
        player.play();

        */


        stage.setScene(startScene);
        stage.show();
    }
}