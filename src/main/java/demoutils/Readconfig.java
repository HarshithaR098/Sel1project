package demoutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.ApplicationContants;

public class Readconfig implements ApplicationContants {
	public static String getFromproperty(String key) throws IOException   {
		FileInputStream fis= new FileInputStream(CONFIG_PATH);
		Properties prop= new Properties();
		prop.load(fis);
		String url = prop.getProperty(key);
		return url;
	}

}
