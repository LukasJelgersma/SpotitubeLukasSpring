package dea.spotitube.spring.spotitubelukasspring.datasourceLayer.util;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    private final Properties properties;

    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Can't acces property file database.properties", e);
        }
    }

    public String connectionString(){
        return properties.getProperty("connectionString");
    }

}
