package _07_StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergei on 12/11/15.
 */
public class _7_20_Regex_jpoint {
    public static void main(String[] args) {
        String input = "JokerJpoint";
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < 700; i++) {
            sb.append(input);
        }

//        System.out.println(sb.toString());

//        Pattern pattern = Pattern.compile("(Joker|Jpoint)+?");
//        Pattern pattern = Pattern.compile("(Joker|Jpoint)++");
        Pattern pattern = Pattern.compile("(?>Joker|Jpoint)+"); // Atomic grouping
        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + ": " + matcher.group(i));
            }
        }
    }
}
