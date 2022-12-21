package StartUpApplication;



import Paint.PaintApplication;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


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
