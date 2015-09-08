package _7_inheritance._2_execp;

/**
 * Created by Sergei on 30.03.2015.
 */
public class App00 {
}

class A {
    void m() {}
}

class B extends A {
    @Override
    // Compile time error
    void m() /*throws Exception*/ {

    }
}



