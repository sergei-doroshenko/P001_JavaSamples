package _12_Localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class _12_6_LocalizedHello2 {
	public static void printMovieDetails(ResourceBundle resBundle) {
		String movieName = resBundle.getString("MovieName"); 
		Long revenue = (Long)(resBundle.getObject("GrossRevenue"));
		Integer year = (Integer) resBundle.getObject("Year"); 

		System.out.println("Movie " + movieName + "(" + year +")" + " grossed "+ revenue);
	}

	public static void main(String args[]) {
		// print the largest box-office hit movie for default (US) locale 
		Locale locale = Locale.getDefault(); 
		printMovieDetails(ResourceBundle.getBundle("_12_Localization._12_4_ResBundle", locale));
		
		// print the largest box-office hit movie for Italian locale 
		locale = new Locale("it", "IT", ""); 
		printMovieDetails(ResourceBundle.getBundle("_12_Localization._12_4_ResBundle", locale));
	}
}
