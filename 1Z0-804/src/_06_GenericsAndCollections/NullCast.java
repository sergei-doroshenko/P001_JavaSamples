package _06_GenericsAndCollections;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sergei on 11/18/15.
 */
public class NullCast {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(new String[]{"hello", "Jhon"});
        System.out.println(strings);
        strings = null;
        List<String> list = (List) strings;
        System.out.println(list);
    }
}
