package _07_StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This program demonstrates how we can validate an IP address
public class _7_16_Regex8 {

	public static void main(String[] args) {
		String regex0 = "\\{START}.*\\{END}";
		String regex1 = "\\{START}.*?\\{END}";
		String regex2 = "\\{START}[^\\{]*\\{END}";
		String regex3 = "\\{START\\}";

		String regex4 = "[^\\d]*\\s\\d*\\s\\w*";

		Pattern p = Pattern.compile(regex3);

		String ipStr1 = "{START} Mary {END} had a {START} little lamb {END}";
		String ipStr2 = "hello 1995 goodbye";

		Matcher m = p.matcher(ipStr1);

		if (m.matches()) {
			System.out.println("0: " + m.group(0));
			/*System.out.println("1: " + m.group(1));
			System.out.println("2: " + m.group(2));*/
		}
		// Here '\G' - Boundary Matcher, the end of the previous match.
		String[] tokkens = "hello my darling".split("(?<=\\G.{2})");
		for (String tokken : tokkens) {
			System.out.println("[" + tokken + "]");
		}
	}
}