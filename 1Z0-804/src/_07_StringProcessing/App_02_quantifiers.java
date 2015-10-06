package _07_StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sergei on 06.10.2015.
 */
public class App_02_quantifiers {
    // (?=pattern) - look ahead
    // (?!pattern) - Negative Lookahead
    // (?<=pattern) - look behind
    // (?:pattern) - not capture the group, you need to know appropriate group number to get it.
    public static void main(String[] args) {
        String input = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post office, , Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
        String str ="http://mail.ru";

        String regex_0 = "(?<=no\\s)(\\d+)(?=,)";
        String regex_1 = "(?:no\\s)(\\d+)(?:,)";

        String regex_2 = "(?:http|https)://(.*)";
        Pattern pattern = Pattern.compile(regex_1);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
        /*if (matcher.find()) {
            for (int i = 0; i < 2; i++) {
                System.out.println(matcher.group(i));
            }
        }*/
    }
}
