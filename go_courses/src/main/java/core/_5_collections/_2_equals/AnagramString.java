package core._5_collections._2_equals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergei on 16.03.2015.
 */
public class AnagramString {
    public final String value;

    public AnagramString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnagramString that = (AnagramString) o;

        char[] a = this.value.toCharArray();
        char[] b = that.value.toCharArray();

       /* Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);*/

        int c0 = 0;
        for (char ch : a) {
            c0 += ch;
        }

        int c1 = 0;
        for (char ch : b) {
            c1 += ch;
        }

        return c0 == c1;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }

    public static void main(String[] args) {
        AnagramString as0 = new AnagramString("AB");
        AnagramString as1 = new AnagramString("BA");

        System.out.println(as0.equals(as1));


        Set<AnagramString> set = new HashSet<>();
        set.add(new AnagramString("ABC"));
        set.add(new AnagramString("XYZ"));
        /** !!!! WE NEED TO OVERRIDE HASHCODE !!!! **/
        System.out.println(set.contains(new AnagramString("BCA")));
        set.add(new AnagramString("BAC"));
        System.out.println(set);
    }
}
