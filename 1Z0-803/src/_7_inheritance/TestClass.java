package _7_inheritance;

/**
 * Created by Sergei on 02.03.2015.
 */
public class TestClass implements T1, T2 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.m1();
        /*not compile*/
        //tc.VALUE; // reference to VALUE is ambiguous
    }

    public void m1(){}
}

interface T1{
    int VALUE = 1;
    void m1();
}
interface T2{
    int VALUE = 2;
    void m1();
}