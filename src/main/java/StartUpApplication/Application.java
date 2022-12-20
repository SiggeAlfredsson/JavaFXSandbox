package StartUpApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/ApplicationScene.fxml"));
        Scene startScene = new Scene(root);


        stage.setTitle("JavaFX Sandbox!");
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);


      /*  Media media = new Media("music.mp3");  // This does not work. I think code is fine, just that it don't recognize the mp3 file as a mp3.
        MediaPlayer player = new MediaPlayer(media);
        player.play(); */


        stage.setScene(startScene);
        stage.show();
    }
}