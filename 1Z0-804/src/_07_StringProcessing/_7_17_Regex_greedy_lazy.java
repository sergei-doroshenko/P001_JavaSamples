package _07_StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sergei on 03.10.2015.
 */
public class _7_17_Regex_greedy_lazy {
    public static void main(String[] args) {
        String input = "A tasty apple";
        String greedy = "A ta(.+)"; // [A tasty apple]
        String reluctant = "A ta(.+?)"; // lazy [A tas]

        Pattern pat = Pattern.compile(reluctant);
        Matcher matcher = pat.matcher(input);

        if ( matcher.find() ) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println("[" + matcher.group(i) + "]");
            }
            /*System.out.println("[" + input.substring(matcher.regionStart(),
                    matcher.regionEnd()) + "]");*/
        }
    }
}
