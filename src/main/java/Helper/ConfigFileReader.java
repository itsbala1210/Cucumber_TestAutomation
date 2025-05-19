package Helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static final ConfigFileReader configFileReader = new ConfigFileReader();
    private static final String FILE = "src/test/resources/config.properties";
    private static final Logger log = LoggerFactory.getLogger(ConfigFileReader.class);
    private Properties properties;

    private ConfigFileReader() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            log.error("Unable to load config properties", e);
            throw new IllegalArgumentException("config.properties not found at " + FILE);
        }
    }

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
