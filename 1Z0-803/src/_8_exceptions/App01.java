package _8_exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App01 {
}

class A {
    public A() throws IOException {} // constructor

    void m1() throws IOException {}  // method
}

class B extends A {
    public B() throws IOException, FileNotFoundException {

    }

    void m1() {} // not valid throws Exception {}
}

class C extends B {
    public C() throws Exception {
        super();
    }

    void m1() {}
}
