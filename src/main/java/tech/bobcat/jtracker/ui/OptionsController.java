package tech.bobcat.jtracker.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tech.bobcat.jtracker.Controller;
import tech.bobcat.jtracker.data.Options;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsController extends Controller implements Initializable {

    @FXML private TextField timeFrequencyField;
    @FXML private CheckBox notifySoundBox;
    @FXML private Button doneButton;

    private Stage stage = null;
    private Options result = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notifySoundBox.setDisable(true);
        doneButton.setOnAction((event) -> {
            result = new Options();
            result.setTimeFrequency(Integer.parseInt(timeFrequencyField.getText()));
            result.setPlayNotificationSound(true);
            closeStage();
        });
    }

    public Options getResult() {
        return result;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void closeStage() {
        if (stage != null) {
            stage.close();
        }
    }
}
