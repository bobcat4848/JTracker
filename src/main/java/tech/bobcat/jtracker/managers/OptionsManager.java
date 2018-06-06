package tech.bobcat.jtracker.managers;

import tech.bobcat.jtracker.data.Options;

public class OptionsManager extends WriterManager{

    private Options options;

    public OptionsManager() {
        super("options.yml");
        options = new Options();
    }

    public void load() {

    }

    public void save() {

    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Options getOptions() {
        return options;
    }

}
