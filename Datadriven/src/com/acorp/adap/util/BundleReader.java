package com.acorp.adap.util;
import java.util.ResourceBundle;
/**
 * BundleReader is a class to read the Resource Bundle Files
 * @author neetu
 * @version 1.0
 *
 */
// Single Line Comments
/*
 * Multi Line Comments
 */
public interface BundleReader {
	/**
	 * This method read the config file and return the ResourceBundle Object
	 * @return
	 */
	public static ResourceBundle readResourceBundle(){
		//ResourceBundle rb = new ResourceBundle(); // abstract class
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
	public static String getValue(String key){
		ResourceBundle rb = readResourceBundle();
		String value = rb.getString(key);
		return  value;
	}
	
}