package _07_StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergei on 12/11/15.
 */
public class App_03_jpoint {
    public static void main(String[] args) {
        String input = "stubb<hello:item>text1</hello:item>stubb" +
                "   stubb<good:item>text2</good:item>stubb;\n";
//        Pattern pattern = Pattern.compile("<(?:.*?):item>(.*?)</.*?:item>");
        Pattern pattern = Pattern.compile("<(?:[^:>]*?):item>([^<]*?)</[^:>]*?:item>");
//        Pattern pattern = Pattern.compile("<(?:.*?):item>(.*?)<\\1:item>");
        Matcher matcher = pattern.matcher(input);

        /*int start = 0;
        while (matcher.find(start)) {
            start = matcher.end();
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }*/

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + ": " + matcher.group(i));
            }
        }
    }
}
