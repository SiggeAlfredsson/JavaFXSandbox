package StartUpApplication;



import Paint.PaintApplication;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private static MediaPlayer player;
    private Media media;

    @FXML
    private Button paintBtn;

    @FXML
    private Slider volumeSlider;

    private PaintApplication paintStage;

    public void setPaintStage(PaintApplication paintStage) {
        this.paintStage = paintStage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        try {
            media = new Media(getClass().getResource("/music.wav").toURI().toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        player = new MediaPlayer(media);
        player.setVolume(0); // sets volume when starting
        player.play();

        volumeSlider.setValue(player.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                player.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }

    public void paint(ActionEvent actionEvent) {
        try {
            paintStage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        paintBtn.getScene().getWindow().hide();
    }
}
