package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static utils.PathUtils.PROPERTIES_FILE_PATH;

public class PropertyUtils {

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(PROPERTIES_FILE_PATH);
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }
}


