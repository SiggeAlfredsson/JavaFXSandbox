package Paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.canvas.Canvas;

public class Controller implements Initializable {

    public Button selectSizeBtn;
    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private Spinner<Integer> heightSpinner;

    @FXML
    private Spinner<Integer> widthSpinner;


    @FXML
    void SelectSize(ActionEvent event) throws IOException {
        int width = 0;
        int height = 0;
        if (widthSpinner != null) {
            width = widthSpinner.getValue();
        }
        if (heightSpinner != null) {
            height = heightSpinner.getValue();
        }
        Settings settings = new Settings(width, height);


        //Parent root = FXMLLoader.load(getClass().getResource("/PaintApplication.fxml"));

        Canvas canvas = new Canvas(settings.getWidth(), settings.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLACK);

        StackPane root = new StackPane(canvas);


        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            double x = e.getX();
            double y = e.getY();
            gc.fillOval(x, y, 10, 10);


        });



        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.setWidth(settings.getWidth());
        //stage.setHeight(settings.getHeight());
        stage.show();

        System.out.println(settings.getHeight() + ":" + settings.getWidth());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        SpinnerValueFactory<Integer> widthValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1920); // limited to 1920x1080 atm, in future make it able to scale!
        SpinnerValueFactory<Integer> heightValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1080);

        widthValueFactory.setValue(1280);
        heightValueFactory.setValue(720);


        if (widthSpinner != null) {
            widthSpinner.setValueFactory(widthValueFactory);
        }
        if (heightSpinner != null) {
            heightSpinner.setValueFactory(heightValueFactory);
        }

    }
}
