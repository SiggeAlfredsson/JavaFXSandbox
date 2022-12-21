package Paint;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintApplication {

    private Stage stage;

    public void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/PaintApplication.fxml"));

            Parent root = loader.load();

            Controller controller = loader.getController();

            Scene scene = new Scene(root);


            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StartPaintApplicationStage() {
        stage = new Stage();
        stage.setTitle("Paint");
    }

    public void showStage() {
        loadFXML();
        stage.show();
    }
}