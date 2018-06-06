package tech.bobcat.jtracker;

import javafx.stage.Stage;

public abstract class Controller {

    protected Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stage) {
        stage = null;
    }
}
