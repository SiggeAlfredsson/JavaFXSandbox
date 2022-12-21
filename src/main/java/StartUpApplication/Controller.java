package StartUpApplication;



import Paint.PaintApplication;
import Paint.StartPaint;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Slider volumeSlider;

    public void paint(javafx.event.ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.hide();

        StartPaint startPaint = new StartPaint();
        startPaint.StartPaintStage();

        startPaint.showStage();



      /*  PaintApplication drawingApp = new PaintApplication();
        Stage drawingAppStage = new Stage();
        drawingAppStage.setOnCloseRequest(event -> stage.show());
        drawingApp.start(drawingAppStage); */

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
