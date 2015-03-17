package core._6_oop._0_type;

/**
 * Created by Sergei on 16.03.2015.
 */
public class App02 {
    public static void main(String[] args) {
        funcArg(new Child());

        Parent ref0 = new Child();
        ref0.stMethod();   // Parent static method
        ref0.virtMethod(); // Child virtual method

        System.out.println(ref0.name); // Parent

        Child ref1 = new Child();
        ref1.stMethod();   // Child static method
        ref1.virtMethod(); // Child virtual method

        System.out.println(ref1.name); // Child

        Child.stMethod(); // if haven't  stMethod() in Child class

    }

    public static void funcArg(Parent ref) { // choose maximum highest class where is needed methods

    }

    public static Parent funcRet() {
        return new Child();
    }
}

