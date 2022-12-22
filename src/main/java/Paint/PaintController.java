package Paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


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
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            if (btnBox.isSelected()) {
                double x = e.getX();
                double y = e.getY();
                gc.fillRect(x , y , 10 , 10);
            }
        });

    } //done

    @FXML
    void btnBrushEvent(ActionEvent event) {


            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                if (btnBrush.isSelected()) {
                    gc.beginPath();
                    double x = e.getX();
                    double y = e.getY();
                    gc.moveTo(x, y);
                }
            });

            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
                if (btnBrush.isSelected()) {
                    double x = e.getX();
                    double y = e.getY();
                    gc.lineTo(x, y);
                    gc.stroke();
                }
            });
    } // done

    @FXML
    void btnCircleEvent(ActionEvent event) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            if (btnCircle.isSelected()) {
                double x = e.getX();
                double y = e.getY();
                gc.fillOval(x , y , 10 , 10);
            }
        });
    } //done


    @FXML
    void btnEraserEvent(ActionEvent event) {

    } // do not know how to make this work


    double startX;
    double startY;
    double endX;
    double endY;
    @FXML
    void btnLineEvent(ActionEvent event) {
        if (btnLine.isSelected()) {
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                startX = e.getX();
                startY = e.getY();
            });

            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
                endX = e.getX();
                endY = e.getY();
                gc.setStroke(Color.GRAY);
                gc.setLineDashes(5, 5);
                gc.strokeLine(startX, startY, endX, endY);
            });

            canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
                endX = e.getX();
                endY = e.getY();
                double minX = Math.min(startX, endX);
                double minY = Math.min(startY, endY);
                double maxX = Math.max(startX, endX);
                double maxY = Math.max(startY, endY);
                gc.clearRect(minX, minY, maxX - minX, maxY - minY);
                gc.setStroke(Color.BLACK);
                gc.setLineDashes(0);
                gc.strokeLine(startX, startY, endX, endY);
            });
        }
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
        stage.setAlwaysOnTop(true);

        stage.setScene(scene);
        stage.show();

    }


}
