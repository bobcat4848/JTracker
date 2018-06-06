package tech.bobcat.jtracker.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.Serializable;

public class Website implements Serializable {

    private String name;
    private String url;
    private String lastChange;
    private boolean alert;

    private Document doc;

    public Website() {
        this("No Name", "No URL", false);
    }

    public Website(String name, String url, boolean alert) {
        this.name = name;
        this.url = url;
        this.alert = alert;
    }

    // Accessor Methods
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLastChange() {
        return lastChange;
    }

    public String getDate() {
        // implement date parse
        return "";
    }

    public Document getDocument() {
        return doc;
    }

    public boolean getAlert() {
        return alert;
    }

    // Mutator Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;

        try {
            this.doc = Jsoup.connect(url).get();
        } catch (IOException ex) { ex.printStackTrace(); };
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public void setDoc() {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //
    //

    public String toString() {
        return name + " " + url +  " " + lastChange;
    }

}
