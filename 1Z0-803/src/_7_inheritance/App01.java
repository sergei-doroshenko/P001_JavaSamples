package _7_inheritance;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App01 {
    public static void main(String[] args){
        A0 a = new B0();
        a.print();
    }
}

class A0{
    A0() {  print();   }
    void print() { System.out.println("A"); }
}

class B0 extends A0 {
    int i =   4;
    void print() { System.out.println(i); }
}
