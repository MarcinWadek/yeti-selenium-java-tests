package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Properties properties;

    public Config() {
        properties = getProperties();
    }

    private Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load properties file: " + e);
        }
        return prop;
    }

    public String getApplicationURL() {
        return properties.getProperty("application.url");
    }

    public String getGalleryURL() {
        return properties.getProperty("gallery.url");
    }

    public String getLoginURL() {
        return properties.getProperty("login.url");
    }

    public String getNewsURL() {
        return properties.getProperty("news.url");
    }

    public String getAboutUsURL() {
        return properties.getProperty("aboutus.url");
    }

    public String getTrainingURL() {
        return properties.getProperty("trainings.url");
    }

    public String getToursURL() {
        return properties.getProperty("tours.url");
    }

    public String getApplicationUser() {
        return properties.getProperty("application.user");
    }

    public String getApplicationPassword() {
        return properties.getProperty("application.password");
    }

    public String getApplicationFirstName() {
        return properties.getProperty("application.firstName");
    }

    public String getApplicationLastName() {
        return properties.getProperty("application.lastName");
    }

}