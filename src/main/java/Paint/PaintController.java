package Paint;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Paint.PaintApplication.canvas;
import static Paint.PaintApplication.gc;

public class PaintController implements Initializable {

    @FXML
    private Slider objectSizeSlider;

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
    void btnBoxEvent(ActionEvent event) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            if (btnBox.isSelected()) {
                double x = e.getX();
                double y = e.getY();
                gc.fillRect(x , y , objectSize , objectSize);
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
                gc.closePath();
                gc.beginPath();
                gc.moveTo(x, y);
            }
        });
    } // done


    double objectSize = 50;
    String objectColor;

    @FXML
    void btnCircleEvent(ActionEvent event) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            if (btnCircle.isSelected()) {
                double x = e.getX();
                double y = e.getY();
                gc.fillOval(x , y , objectSize , objectSize);
            }
        });
    } //done


    @FXML
    void btnEraserEvent(ActionEvent event) {

    } // do not know how to make this work


    double startX;
    double startY;
    @FXML
    void btnLineEvent(ActionEvent event) {
        canvas.setOnMousePressed(e -> {
            if (btnLine.isSelected()) {
                startX = e.getX();
                startY = e.getY();
            } else if (btnBrush.isSelected()) {
                gc.beginPath();
                gc.moveTo(e.getX(), e.getY());
            }
        });

        canvas.setOnMouseReleased(e -> {
            if (btnLine.isSelected()) {
                gc.strokeLine(startX, startY, e.getX(), e.getY());
            } else if (btnBrush.isSelected()) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
        });
    }




    @FXML
    void btnSaveEvent(ActionEvent event) {
        PaintApplication.saveCanvas();
    }

    @FXML
    void btnClearEvent(ActionEvent event) {
        PaintApplication.clearCanvas();
    }


    @FXML
    private ColorPicker colorSelect;

    @FXML
    private ColorPicker objectColorSelect;

    @FXML
    void ColorSelectEvent(ActionEvent event) {

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
        gc.setLineWidth(5);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colorSelect.valueProperty().addListener((ObservableValue<? extends Color> observable, Color oldValue, Color newValue) -> {
            gc.setStroke(newValue);
        });

        objectColorSelect.valueProperty().addListener((ObservableValue<? extends Color> observable, Color oldValue, Color newValue) -> {
            gc.setFill(newValue);
        });



        brushSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                gc.setLineWidth(brushSlider.getValue() /10);
            }
        });

        objectSizeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                objectSize=(objectSizeSlider.getValue());
            }
        });
    }
}
