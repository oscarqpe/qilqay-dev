package com.os.foro.gplus.oauth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author oscar edmit
 *
 */
public class GPlusHelper {
	private static final Logger LOG = Logger.getLogger(GPlusHelper.class.getName());
    private static final String CONFIG_PROPERTIES = "gplus.properties";
    public static Properties config = getConfig();
    public static String CLIENT_ID = GPlusHelper.getProperty("com.os.foro.gplus.oauth_client_id");
    public static String GOOGLE_APP_NAME = GPlusHelper.getProperty("com.os.foro.gplus.google_app_name");
    public static String CLIENT_SECRET = GPlusHelper.getProperty("com.os.foro.gplus.oauth_client_secret");
    //public static String GOOGLE_API_KEY = GPlusHelper.getProperty("com.nsp.jh02.alfin.gplus.google_api_key");
    public static String SCOPES = GPlusHelper.getProperty("com.os.foro.gplus.oauth_scopes"); // Space separated list of OAuth scopes
    public static String REDIRECT_URI = GPlusHelper.getProperty("com.os.foro.gplus.oauth_redirect_uri");
    
    //Drive

    /**
     * Load the configuration file for this application.
     *
     * @return application configuration properties
     */
    private static Properties getConfig() {
        Properties properties = null;

        try {
            File propertiesFile = new File(GPlusHelper.class.getClassLoader().getResource(CONFIG_PROPERTIES).toURI());

            properties = new Properties();
            properties.load(new FileInputStream(propertiesFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to load config file: " + CONFIG_PROPERTIES);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config file: " + CONFIG_PROPERTIES);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to load config file: " + CONFIG_PROPERTIES);
        }

        return properties;
    }

    /**
     * A simple static helper method that fetches a configuration
     *
     * @param key The name of the property for which you would like the
     * configured value
     * @return A String representation of the configured property value
     * @throws RuntimeException if request property can not be found
     */
    public static String getProperty(String key) {
        if (!config.containsKey(key) || config.getProperty(key).trim().isEmpty()) {
            LOG.log(Level.SEVERE, "Could not find property {0}", key);
            throw new RuntimeException("Could not find property " + key);
        }
        return config.getProperty(key).trim();
    }
}
