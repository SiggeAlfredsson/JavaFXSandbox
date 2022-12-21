package StartUpApplication;



import Paint.PaintApplication;
import Paint.StartPaint;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import Paint.StartPaint;

public class Controller implements Initializable {


    @FXML
    private Button paintBtn;

    @FXML
    private Slider volumeSlider;

    private StartPaint secondStage;

    @FXML
    public void initialize() {
        paintBtn.setOnAction(event -> {
            try {
                secondStage.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            paintBtn.getScene().getWindow().hide();
        });
    }

    public void setSecondStage(StartPaint secondStage) {
        this.secondStage = secondStage;
    }




      /*  PaintApplication drawingApp = new PaintApplication();
        Stage drawingAppStage = new Stage();
        drawingAppStage.setOnCloseRequest(event -> stage.show());
        drawingApp.start(drawingAppStage); */



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void paint(ActionEvent actionEvent) {
        try {
            secondStage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        paintBtn.getScene().getWindow().hide();
    }
}
