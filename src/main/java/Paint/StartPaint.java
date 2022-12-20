package Paint;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPaint {

    private Stage stage;

    public void loadFXML() {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartPaint.fxml"));

            Parent root = loader.load();

            Controller controller = loader.getController();

            Scene scene = new Scene(root);

            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StartPaintStage() {
        stage = new Stage();
        stage.setTitle("Paint Settings");

    }

    public void showStage() {
        loadFXML();
        stage.show();
    }


}
