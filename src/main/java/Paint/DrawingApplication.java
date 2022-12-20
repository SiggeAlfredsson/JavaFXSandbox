package Paint;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DrawingApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(480, 480);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        gc.setFill(Color.BLACK);


        Button saveButton = new Button("Save n exit");
        saveButton.setTranslateX(195);
        saveButton.setTranslateY(220);

        Button clearButton = new Button("Clear");
        clearButton.setTranslateX(-210);
        clearButton.setTranslateY(220);



        saveButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    WritableImage image = new WritableImage(480, 480);
                    canvas.snapshot(null, image);
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "svg", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
                double x = e.getX();
                double y = e.getY();
                gc.fillOval(x, y, 10, 10);
            });


        clearButton.setOnAction(event -> gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));




        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        root.getChildren().add(saveButton);
        root.getChildren().add(clearButton);


        primaryStage.setTitle("Drawing Application");
        primaryStage.setScene(scene);
        primaryStage.show();





    }
}