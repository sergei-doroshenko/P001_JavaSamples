package _06_GenericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 13.10.2015.
 */
public class App00_gen {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(123);
        ints.add(345);
        print(ints, "[", "]");

        List<Float> floats = Arrays.asList(new Float[] {103.34f, 738.5f});
        print(floats, "<", ">");

        List<? super C> some1 = new ArrayList<A>();
        List<? super C> some2 = new ArrayList<B>();
        List<? super C> some3 = new ArrayList<C>();
    }

    public static /*<T extends Number>*/ void print(List<? extends Number> numbers, String left, String right) {
        numbers.stream()
                .forEach(n -> System.out.println(left + n.longValue() + right));
    }
}

class A {

}

class B extends A {

}

class C extends B {

}
