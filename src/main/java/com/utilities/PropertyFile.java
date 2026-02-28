package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {
	
	private static FileInputStream input;
	private static Properties prop;
	
	static {
		String propertyfilepath = System.getProperty("user.dir")+File.separator+"PropertyFile"+File.separator+"input.properties";
		
		try {
			input = new FileInputStream(propertyfilepath);
			prop = new Properties();
			prop.load(input);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String Key) {
		return prop.getProperty(Key);
		
	}

}
