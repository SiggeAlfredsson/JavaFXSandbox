package Paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button selectSizeBtn;

    @FXML
    private Spinner<Integer> heightSpinner;

    @FXML
    private Spinner<Integer> widthSpinner;

    @FXML
    void SelectSize(ActionEvent event) {
      //  Settings settings = new Settings(widthSpinner.getValue(),heightSpinner.getValue());

        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.hide();

        PaintApplication startApplication = new PaintApplication();
        startApplication.StartPaintApplicationStage();

        startApplication.showStage();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> widthValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1920);
        SpinnerValueFactory<Integer> heightValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1080);

        widthValueFactory.setValue(1280);
        heightValueFactory.setValue(720);

        widthSpinner.setValueFactory(widthValueFactory);
        heightSpinner.setValueFactory(heightValueFactory);

    }
}
