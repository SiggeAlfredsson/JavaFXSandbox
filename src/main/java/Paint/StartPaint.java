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

            // Set the root node of the scene to be the element with the fx:id "root"
            // defined in the FXML file
            Parent root = loader.load();

            // Get a reference to the controller associated with the FXML file
            StartPaintController controller = loader.getController();

            // You can now use the controller instance to interact with the elements in the FXML file
            // ...

            // Create a new scene with the root node as the root element
            Scene scene = new Scene(root);

            // Set the scene on the stage
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
