package _12_Localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * java -Duser.language=it -Duser.region=IT _12_3_LocalizedHello
 */
public class _12_3_LocalizedHello {
	public static void main(String args[]) {
		Locale currentLocale = Locale.getDefault(); 
		ResourceBundle resBundle = ResourceBundle.getBundle("_12_Localization.ResourceBundle", currentLocale);
		System.out.printf(resBundle.getString("Greeting")); 
	}
}