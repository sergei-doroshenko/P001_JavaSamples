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

        List<A> list0 = Arrays.asList(new A[]{new A()});
        List<B> list1 = Arrays.asList(new B[]{new B()});
        List<C> list2 = Arrays.asList(new C[]{new C()});

        consume1(list0);
        consume1(list1);
        consume1(list2);

        System.out.println(produce(list0));
        System.out.println(produce(list1));
        System.out.println(produce2(list2));

    }

    // If you put objects into a parametrized container, use super
    // An "out" variable (output) is defined with a lower bounded wildcard, using the super keyword.
    public static void consume1(List<? super C> list) {
        System.out.println("Consume list of: " + list.get(0).getClass().getSimpleName() );
    }

    // If you get something from a parametrized container, use extends.
    // An "in" variable (source) is defined with an upper bounded wildcard, using the extends keyword.
    public static Double produce(List<? extends A> list) {
        return list.stream().mapToDouble(i -> i.getVal()).sum();
    }
    // The same as previous
    public static <T extends A> Double produce2(List<T> list) {
        T item = list.get(0);
        System.out.println("Produce from list of type: " + item.getClass().getSimpleName());
        return list.stream().mapToDouble(i -> i.getVal()).sum();
    }

    public static /*<T extends Number>*/ void print(List<? extends Number> numbers, String left, String right) {
        numbers.stream()
                .forEach(n -> System.out.println(left + n.longValue() + right));
    }
}

class A {
    Double getVal() {
        return 1d;
    }
}

class B extends A {
    @Override
    Double getVal() {
        return 2d;
    }
}

class C extends B {
    @Override
    Double getVal() {
        return 3d;
    }
}
