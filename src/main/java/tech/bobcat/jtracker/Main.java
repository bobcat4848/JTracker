package tech.bobcat.jtracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    public static Manager manager = new Manager();

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        manager.load();

        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("JTracker");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/icon.png"));
        Scene mainScene = new Scene(root, 590, 390);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        //NotificationHelper.showNotification("There has been an update to the website, google");

        new Timer().schedule (
                new TimerTask() {
                    int count = 0;
                    public void run() {
                        if (count > 0) manager.update();
                        count++;
                    }
                }, 0, manager.getOptionsManager().getOptions().getTimeFrequency()*1000);
    }

    @Override
    public void stop() {
        //System.out.println("Stage is closing!");
        manager.save();
        System.exit(0);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
