package com.web.util;

import java.io.InputStream;
import java.util.Properties;

public class FileUtil {
	
	public static InputStream readFileFromResources(String filepath) {
		InputStream inputStream = null;
		try {
			ClassLoader classloader= Thread.currentThread().getContextClassLoader();
			inputStream = classloader.getResourceAsStream(filepath);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return inputStream;
		
	}
	public static String readLocators(String fileName,String locatorName ) {
		Properties properties= new Properties();
		String value= null;
		try {
			properties.load(readFileFromResources("data/locators/"+fileName+".properties"));
			value = properties.getProperty(locatorName);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
		
		
	}

}
