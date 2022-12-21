package Paint;

import StartUpApplication.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;

public class PaintApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartPaint.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        FXMLController controller = loader.getController();
        controller.setStage(stage);

        stage.setTitle("Paint");
        stage.setScene(scene);
        stage.show();
    }

    public static void showStage2(Settings settings) throws IOException {

        Stage stage = new Stage();
        Canvas canvas = new Canvas(settings.getWidth(), settings.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLACK);



        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            double x = e.getX();
            double y = e.getY();
            gc.fillOval(x, y, 10, 10);
        });

        stage.setResizable(false);
        stage.setTitle("Paint");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}