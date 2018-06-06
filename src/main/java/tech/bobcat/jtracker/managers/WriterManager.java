package tech.bobcat.jtracker.managers;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class WriterManager {

    protected FileReader websiteFileReader;
    protected FileWriter websiteFileWriter;
    protected YamlReader yamlFileReader;
    protected YamlWriter yamlFileWriter;

    protected File file;

    public WriterManager(String fileName) {
        try {
            file = new File(fileName);
            file.createNewFile();
            //System.out.println(file.getAbsolutePath());

            websiteFileReader = new FileReader(file);
            yamlFileReader = new YamlReader(websiteFileReader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public abstract void load();
    public abstract void save();
}
