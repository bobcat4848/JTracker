package tech.bobcat.jtracker.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.*;
import tech.bobcat.jtracker.Controller;
import tech.bobcat.jtracker.data.Website;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static tech.bobcat.jtracker.Main.manager;

public class MainController extends Controller implements Initializable {

    @FXML private TableView<Website> websiteTable;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn urlColumn;
    @FXML private TableColumn lastChangeColumn;
    @FXML private TableColumn alertColumn;
    private ObservableList<Website> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // nothing yet
        data = FXCollections.observableArrayList(manager.getWebsiteManager().getWebsites());
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        urlColumn.setCellValueFactory(new PropertyValueFactory("url"));
        lastChangeColumn.setCellValueFactory(new PropertyValueFactory("lastChange"));
        alertColumn.setCellValueFactory(new PropertyValueFactory("alert"));

        websiteTable.setItems(data);
    }

    // This method should only be called if a new website has been added and the table must be updated
    public void update() {
        data = FXCollections.observableArrayList(manager.getWebsiteManager().getWebsites());
        websiteTable.setItems(data);
    }

    @FXML
    private void openCreate() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/creator.fxml"));
        // initializing the controller
        CreateController popupController = new CreateController();
        loader.setController(popupController);

        show(loader, popupController);

        if(popupController.getResult() != null) {
            manager.getWebsiteManager().addWebsite(popupController.getResult());
            update();
        }
    }

    @FXML
    private void openOptions() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/options.fxml"));
        // initializing the controller
        OptionsController popupController = new OptionsController();
        loader.setController(popupController);

        show(loader, popupController);

        if (popupController.getResult() != null) {
            manager.getOptionsManager().setOptions(popupController.getResult());
        }
    }

    private void show(FXMLLoader loader, Controller popupController) {
        try {
            Parent layout = loader.load();
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the controller to close the stage)
            popupController.setStage(popupStage);
            if(main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setAlwaysOnTop(true);
            popupStage.setResizable(false);
            popupStage.getIcons().add(new Image("/icon.png"));
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
