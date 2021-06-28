package utils;

import java.util.ResourceBundle;

public class PropertyLoader {

    public static ResourceBundle res = ResourceBundle.getBundle("config");

    public static String getProperty(String key){
        return res.getString(key);
    }
}
