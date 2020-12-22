package com.italoschramm.breathfantasy;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class LocaleLanguage{
	
	public static ResourceBundle bundle;
	private static PropertiesConfiguration config;
	private static Locale locale;
	private static LocaleLanguage instance;
	
	public LocaleLanguage() {
		config = new PropertiesConfiguration();
		try {
			config.load("application.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		locale = EnumLanguage.getLanguage(config.getByte("language")).getLocale();
		bundle = ResourceBundle.getBundle("messages", locale);
	}
	
	public String getMessage(String key) {
		return bundle.getString(key);
	}
	
	public String getMessage(String key, String str1, String str2) {
		String[] str = new String[2];
		str[0] = str1;
		str[1] = str2;
		return getMessage(key, str);
	}
	
	public String getMessage(String key, String str1) {
		String[] str = new String[1];
		str[0] = str1;
		return getMessage(key, str);
	}
	
	public String getMessage(String key, String[] arguments) {

		MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(locale);

	    String output;
	    try{
	    	formatter.applyPattern(bundle.getString(key));
	    	output = formatter.format(arguments);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	output = "";
	    }
	    return output;
	}
	
	public static LocaleLanguage getInstance() {
		if(instance == null){
			instance = new LocaleLanguage();	
		}
		return instance;
	}
}
