package _07_StringProcessing.Listing_7_3;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
// This example demonstrates how to search multiple occurences of a search string
public class SearchString3 {

	public static final String DOUBLE_REGEX = "^-?[.0-9]{1,7}$";

	public static void main(String[] s) {
		String str = "I am a student. I am preparing for OCPJP";
		int fromIndex = 0;
		while(str.indexOf("am", fromIndex) > -1) {
			fromIndex = str.indexOf("am", fromIndex);
			System.out.println("Substring \"am\" occurs at index: " + fromIndex);
			fromIndex++;
		}

		String string = "string1, string2, string3";
		System.out.println(string.replaceAll("string(?:1|2)", "blah"));

		String doubleStr = "-.00";
		System.out.println(Pattern.compile(DOUBLE_REGEX).matcher(doubleStr).matches());
		System.out.println(new Double(doubleStr));

		System.out.println(new BigDecimal("-.0").toString());
	}
}