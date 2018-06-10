package tech.bobcat.jtracker;

import tech.bobcat.jtracker.managers.NotificationManager;
import tech.bobcat.jtracker.managers.OptionsManager;
import tech.bobcat.jtracker.managers.WebsiteManager;

public class Manager {

    private WebsiteManager websiteManager;
    private OptionsManager optionsManager;
    public NotificationManager notificationManager;

    public Manager() {
        websiteManager = new WebsiteManager();
        optionsManager = new OptionsManager();
        notificationManager = new NotificationManager();
    }

    protected void load() {
        websiteManager.load();
        optionsManager.load();
    }

    public void save() {
        websiteManager.save();
        optionsManager.save();
        notificationManager.close();
    }

    public void update() {
        websiteManager.newUpdate();
    }

    public WebsiteManager getWebsiteManager() {
        return websiteManager;
    }

    public OptionsManager getOptionsManager() {
        return optionsManager;
    }
}
