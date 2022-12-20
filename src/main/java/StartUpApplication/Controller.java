package StartUpApplication;



import Paint.PaintApplication;
import Paint.StartPaint;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {





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
}
