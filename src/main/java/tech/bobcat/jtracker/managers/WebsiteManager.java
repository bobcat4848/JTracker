package tech.bobcat.jtracker.managers;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlWriter;
import org.jsoup.Jsoup;
import tech.bobcat.jtracker.data.Website;
import tech.bobcat.jtracker.util.NotificationHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for managing all the websites and making sure that the list
 * is concurrent with what is in the configuration file.
 */
public class WebsiteManager extends WriterManager {

    private ArrayList<Website> websites = new ArrayList<Website>();
    private int websitesSizeBefore = 0;

    public WebsiteManager() {
        super("websites.yml");
    }

    public void load() {
        try {
            while (true) {
                Website website = yamlFileReader.read(Website.class);
                if (website == null) break;
                //System.out.println(website);
                website.setDoc();
                websites.add(website);
            }
        } catch (YamlException ex) { ex.printStackTrace(); }

        try {
            yamlFileReader.close();
            //System.out.println("Closed");
        } catch (IOException ex) { ex.printStackTrace(); }
        websitesSizeBefore = websites.size();
    }

    public void save() {
        if (websites.size() > websitesSizeBefore) {
            try {
                websiteFileWriter = new FileWriter(file);
                yamlFileWriter = new YamlWriter(websiteFileWriter);
                yamlFileWriter.getConfig().setClassTag("website", Website.class);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                for (Website website : websites) {
                    yamlFileWriter.write(website);
                    //System.out.println("Saving: " + website);
                }
            } catch (YamlException ex) { ex.printStackTrace(); }

            try {
                yamlFileWriter.close();
                //System.out.println("Closed");
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

    public void newUpdate() {
        if (websites.size() > 0) {
            try {
                for(Website web : websites) {
                    if (web.getAlert()) {
                        if (!Jsoup.connect(web.getUrl()).get().equals(web.getDocument())) {
                            NotificationHelper.showNotification("There has been an update to the website, " + web.getName());
                        }
                    }
                }
            } catch (Exception ex) {
                /*ex.printStackTrace();*/
            }
        }
    }

    public void addWebsite(Website website) {
        try {
            Jsoup.connect(website.getUrl()).get();
            websites.add(website);
        } catch (IOException ex) {
            NotificationHelper.showInvalidURL();
        }
    }

    public ArrayList<Website> getWebsites() {
        return websites;
    }
}
