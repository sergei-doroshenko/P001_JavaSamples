package core._6_oop._0_type;

/**
 * Created by Sergei on 16.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Parent ref = new Child();
        Child ref1 = new Child();
        Parent ref2 = new Parent();
        /*Child ref3 = new Parent();*/ // compilation error incomparable types
    }
}
