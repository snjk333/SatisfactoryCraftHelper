package ReceiptService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();

    public Config(String fileName) {
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
