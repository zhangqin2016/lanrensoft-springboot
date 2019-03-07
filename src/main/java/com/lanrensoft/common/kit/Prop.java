package com.lanrensoft.common.kit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by 张钦
 */
public class Prop {
    private static  final Logger logger = LoggerFactory.getLogger(Prop.class);
    private Properties properties = null;

    /**
     * Prop PropKitructor.
     * @see #Prop(String, String)
     */
    public Prop(String fileName) {
        this(fileName, PropKit.DEFAULT_ENCODING);
    }

    /**
     * Prop PropKitructor
     * <p>
     * Example:<br>
     * Prop prop = new Prop("my_config.txt", "UTF-8");<br>
     * String userName = prop.get("userName");<br><br>
     *
     * prop = new Prop("com/jfinal/file_in_sub_path_of_classpath.txt", "UTF-8");<br>
     * String value = prop.get("key");
     *
     * @param fileName the properties file's name in classpath or the sub directory of classpath
     * @param encoding the encoding
     */
    public Prop(String fileName, String encoding) {
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);		// properties.load(Prop.class.getResourceAsStream(fileName));
            if (inputStream == null)
                throw new IllegalArgumentException("Properties file notBuildQueryField found in classpath: " + fileName);
            properties = new Properties();
            properties.load(new InputStreamReader(inputStream, encoding));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        }
        finally {
            if (inputStream != null) try {inputStream.close();} catch (IOException e) {logger.error(e.getMessage(), e);}
        }
    }

    /**
     * Prop PropKitructor.
     * @see #Prop(File, String)
     */
    public Prop(File file) {
        this(file, PropKit.DEFAULT_ENCODING);
    }

    /**
     * Prop PropKitructor
     * <p>
     * Example:<br>
     * Prop prop = new Prop(new File("/var/config/my_config.txt"), "UTF-8");<br>
     * String userName = prop.get("userName");
     *
     * @param file the properties File object
     * @param encoding the encoding
     */
    public Prop(File file, String encoding) {
        if (file == null)
            throw new IllegalArgumentException("File can notBuildQueryField be null.");
        if (file.isFile() == false)
            throw new IllegalArgumentException("File notBuildQueryField found : " + file.getName());

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(new InputStreamReader(inputStream, encoding));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        }
        finally {
            if (inputStream != null) try {inputStream.close();} catch (IOException e) {
                logger.error(e.getMessage(), e);}
        }
    }
    public Prop AddProp(Prop prop){
      this.properties.putAll(prop.getProperties());
        return this;
    }
    public String get(String key) {
        return properties.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Integer getInt(String key) {
        return getInt(key, null);
    }

    public Integer getInt(String key, Integer defaultValue) {
        String value = properties.getProperty(key);
        if (value != null)
            return Integer.parseInt(value.trim());
        return defaultValue;
    }

    public Long getLong(String key) {
        return getLong(key, null);
    }

    public Long getLong(String key, Long defaultValue) {
        String value = properties.getProperty(key);
        if (value != null)
            return Long.parseLong(value.trim());
        return defaultValue;
    }

    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            value = value.toLowerCase().trim();
            if ("true".equals(value))
                return true;
            else if ("false".equals(value))
                return false;
            throw new RuntimeException("The value can notBuildQueryField parse to Boolean : " + value);
        }
        return defaultValue;
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public Properties getProperties() {
        return properties;
    }
}
