package Paint;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintController {

    public static void showController() throws IOException {
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(PaintController.class.getResource("/PaintControllerFXML.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);


        stage.setTitle("JavaFX Sandbox!");
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }


}
