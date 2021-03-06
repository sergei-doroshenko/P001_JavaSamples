package _07_StringProcessing;

import java.math.BigDecimal;
import java.util.regex.Pattern;

// This example demonstrates how to search multiple occurences of a search string
public class _7_3_SearchString3 {

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