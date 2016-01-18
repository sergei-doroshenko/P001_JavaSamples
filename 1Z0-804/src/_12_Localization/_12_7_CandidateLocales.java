package _12_Localization;

import java.util.Locale;
import java.util.ResourceBundle;

// Use a helper method loadResourceBundle to load a bundle given the bundle name and locale 
public class _12_7_CandidateLocales {
	public static void loadResourceBundle(String resourceBundleName, Locale locale) {
		// Pass an instance of TalkativeResourceBundleControl 
		// to print candidate locales
		ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleName, locale, new _12_7_TalkativeResourceBundleControl());
		String rbLocaleName = resourceBundle.getLocale().toString();
		// if the resource bundle locale name is empty, 
		// it means default property file
		if(rbLocaleName.equals("")) {
			System.out.println("Loaded the default property file with name: " + resourceBundleName);
		} else {
			System.out.println("Loaded the resource bundle for the locale: " + resourceBundleName + "." + rbLocaleName);
		}
	}

	public static void main(String[] args) {
		// trace how ResourceBundle_it_IT_Rome.properties is resolved
    	loadResourceBundle("_12_Localization.ResourceBundle", new Locale("it", "IT", "Rome"));
    	loadResourceBundle("_12_Localization.ResourceBundle", new Locale("fr", "CA", ""));
	}
}