package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConfigReader {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(getConfigFilePath())) {
            properties.load(inputStream);
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "No tiene acceso a la base de datos, contacte a soporte", "Telefonia Cortijo",JOptionPane.ERROR_MESSAGE);
        }
        return properties;
    }

    private static String getConfigFilePath() {
        String currentDir = System.getProperty("user.dir");
        return currentDir + "/config.properties" ;       
    }
}
