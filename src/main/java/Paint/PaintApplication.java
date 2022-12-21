package Paint;

import StartUpApplication.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static Paint.PaintController.showController;

public class PaintApplication extends Application {



    private static Stage stage;
    public static Canvas canvas;
    private static Settings settings;
    public static GraphicsContext gc;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartPaint.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        FXMLController controller = loader.getController();
        controller.setStage(stage);

        stage.setTitle("Paint Size Selector");
        stage.setScene(scene);
        stage.show();
    }

    public static void showStage2(Settings settings) throws IOException {



        PaintApplication.settings = settings;
        stage = new Stage();
        canvas = new Canvas(settings.getWidth(), settings.getHeight());
        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLACK);



        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        gc.setLineWidth(10);


       /* if(settings.getWidth()==1920 && settings.getHeight()==1080) {
            stage.setFullScreen(true);
        } */


        stage.setResizable(false);
        stage.setTitle("Paint. " + settings.getWidth() + "x" + settings.getHeight());
        stage.setScene(scene);
        stage.show();
        showController();
        stage.toFront();
    }

    public static void saveCanvas() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                WritableImage image = new WritableImage(settings.getWidth(), settings.getHeight());
                canvas.snapshot(null, image);
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void  drawStraightLine() {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            double x = e.getX();
            double y = e.getY();
            gc.moveTo(x,y);
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            double x = e.getX();
            double y = e.getY();
            gc.lineTo(x, y);
            gc.stroke();
            gc.moveTo(x, y);
        });
    }

    public static void  clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }


    public static void main(String[] args) {
        launch(args);
    }

}