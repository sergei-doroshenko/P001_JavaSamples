package _1_java_basics;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App00 {

    public static char ch0; // default value

    public static void main(String[] args) {
        byte _byte = 100;
        short _short = _byte;
        _byte = (byte) _short;

        int _int = _short;
        _short = (short) _int;

        long _long = _int;
        _int = (int) _long;

        float _float = _long;
        _long = (long) _float;
        _float = _int;
        _int = (int) _float;

        double _double = _float;
        _double = _long;
        _long = (long) _double;
        _double = _int;
        _double = _byte;


        /********************************************************************/
        byte b0 = -128 ;
        int i0 = b0 ;
        b0 = (byte) i0;
        System.out.println(i0 + " " + b0); // -128 -128
        /********************************************************************/
        short s = 1___0; // 1
        /*char c = s;*/ // compilation error, need cast to char
        char c = (char) s;
        /*s = c;*/ // 3 compilation error, need cast to short
        s = (short) c;
        System.out.println(">" + ch0 + "<");
        System.out.println(">" + '\u0000' + "<");
        System.out.println(">" + (char) 0x0000 + "<");
        /*********************************************************************/

        System.out.println(Float.MAX_VALUE);
        float f0 = 1_000_000_000_000_000_000_000.0f;
        System.out.println("Float.MAX_VALUE = " + f0); // prints Float.MAX_VALUE = 1.0E21
        int $ = 100;
        float f1 = 1 - $/100;
        System.out.println("f1 = " + f1); // prints f1 = 0.0

        float f2 = 0 * 1.5f; // legal
        // float f2 = 0 * 1.5; // illegal, need cast to float; return double


        /*********************************************************************/
        // invalid declaration
        // double x=10, double y;
        double x0 = 10/* 10 automatically converted to double */ , y0;
        /* invalid */
        // int x1 = 10.0; // illegal, need cast to int
        /* valid */
        int x1 = (int) 10.0;
        /*********************************************************************/

    }
}
