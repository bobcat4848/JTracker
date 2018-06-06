package tech.bobcat.jtracker.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tech.bobcat.jtracker.Controller;
import tech.bobcat.jtracker.data.Website;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateController extends Controller implements Initializable {

    @FXML private TextField nameText;
    @FXML private TextField urlText;
    @FXML private CheckBox alertBox;
    @FXML private Button doneButton;
    private Stage stage = null;
    private Website result = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        doneButton.setOnAction((event)->{
            result = new Website();
            result.setName(nameText.getText());
            result.setUrl(urlText.getText());
            result.setAlert(alertBox.isSelected());
            closeStage();
        });

    }

    public Website getResult() {
        return result;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void closeStage() {
        if(stage != null) {
            stage.close();
        }
    }

}
