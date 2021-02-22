package com.pdp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public static Properties properties = null;
	public static Properties readPropertiesFile(String Input) {
		try {
			
			File file = new File("Data\\"+Input+".properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();	
		
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return properties;
	}
	
	public static Properties setPropertyValue(Properties property, String fileName, String field, String value) throws IOException{
		File file = new File("Data\\"+fileName+".properties");
		FileWriter fileOut = new FileWriter(file);
		try {
			
			if(!(field==null || field=="")){
				property.setProperty(field, value);				
			}
			property.store(fileOut, null);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return property;
	}
	
	
	public static Properties writePropertiesFile(String strFileName, String strKey, String strValue) {
		
		Properties properties = null;
		try{
			
			File file = new File("Data\\"+ strFileName +".properties");
			//If file doesnot exists then create the same
			if(! file.exists()) {
				file.createNewFile();
			}
			
//			//This for loading the properties File
//			FileInputStream in = new FileInputStream("Data\\"+ strFileName + ".properties");
//			properties = new Properties();
//			properties.load(in);
//			in.close();
			FileInputStream in = new FileInputStream(file);
			properties = new Properties();
			properties.load(in);
			in.close();
			
			
			//This is for writing to the properties file
//			FileInputStream out = new FileInputStream("Data\\"+ strFileName + ".properties");
//			properties.setProperty(strKey, strValue);
//			//properties.store(out, null);
//			
//			properties.store(new FileWriter("Data\\"+ strFileName + ".properties"), "DB Config file");
//			
//			out.close();
			
			FileOutputStream out = new FileOutputStream("Data\\"+ strFileName + ".properties");
			properties.setProperty(strKey, strValue);
			properties.store(out,  null);
			
			out.close();
			
		}catch(Exception e) {
			
			System.out.println("Error");
			e.printStackTrace();
		}
		
		return properties;
	}
	
}
