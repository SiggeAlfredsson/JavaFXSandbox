package Paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static Paint.PaintApplication.canvas;
import static Paint.PaintApplication.gc;

public class PaintController {

    @FXML
    private Slider boxSlider;

    @FXML
    private Slider brushSlider;

    @FXML
    private ToggleButton btnBox;

    @FXML
    private ToggleButton btnBrush;

    @FXML
    private ToggleButton btnCircle;

    @FXML
    private Button btnClear;

    @FXML
    private ToggleButton btnEraser;

    @FXML
    private ToggleButton btnLine;

    @FXML
    private Button btnSave;

    @FXML
    private Slider eraserSlider;

    @FXML
    private Slider lineSlider;

    @FXML
    void btnBoxEvent(ActionEvent event) {

    }

    @FXML
    void btnBrushEvent(ActionEvent event) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            gc.beginPath();
            double x = e.getX();
            double y = e.getY();
            gc.moveTo(x, y);
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            double x = e.getX();
            double y = e.getY();
            gc.lineTo(x, y);
            gc.stroke();
        });
    }

    @FXML
    void btnCircleEvent(ActionEvent event) {

    }


    @FXML
    void btnEraserEvent(ActionEvent event) {

    }

    @FXML
    void btnLineEvent(ActionEvent event) {

    }




    @FXML
    private Slider brushThicknessSlider;


    @FXML
    void btnSaveEvent(ActionEvent event) {
        PaintApplication.saveCanvas();
    }

    @FXML
    void btnClearEvent(ActionEvent event) {
        PaintApplication.clearCanvas();
    }


    public static void showController() throws IOException {
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(PaintController.class.getResource("/PaintControllerFXML.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);


        stage.setTitle("Paint Controls");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }


}
