package _07_StringProcessing;

import java.util.regex.Pattern;

// This program demonstrates how we can validate an IP address
public class _7_13_Regex7 {
	void validateIP(String ipStr) {
		String regex = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\b";
		System.out.println(ipStr + " is valid? " + Pattern.matches(regex, ipStr));
	}
	public static void main(String[] args) {
		String ipStr1 = "255.245.188.123"; 	// valid IP address 
		String ipStr2 = "255.245.188.273";	// invalid IP address - 273 is greater than 255
		_7_13_Regex7 validator = new _7_13_Regex7();
		validator.validateIP(ipStr1);
		validator.validateIP(ipStr2);
	}
}