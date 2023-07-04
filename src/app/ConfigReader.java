package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(getConfigFilePath())) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String getConfigFilePath() {
        String currentDir = System.getProperty("user.dir");
        return currentDir + "/config.properties" ;       
    }
}
