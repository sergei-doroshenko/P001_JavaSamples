package _7_inheritance._1_class_cast;

/**
 * Created by Sergei on 21.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        BB ref0 = new BB();
        IntA ref1 = (IntA) ref0;
        AA ref2 = (AA) ref1;

        IntA ref3 = (IntA) (AA) ref0;
        ref3.mA(); // BB - mA

        AA ref4 = (AA) (IntA) ref0;
        ref4.mA(); // BB - mA
        System.out.println(ref4.str); // AA

        BB ref5 = (BB) (IntA) ref4;
        ref5.mA(); // BB - mA
        System.out.println(ref5.str); // BB

        /*BB ref6 = (BB) (IntB) ref4; // ClassCastException*/

        /*IntB ref7 = (IntB) (AA) ref5; // ClassCastException*/
    }
}

interface IntA {
    void mA();
}
interface IntB {
    void mB();
}

class AA implements IntA {
    public String str = "AA";
    @Override
    public void mA() {
        System.out.println("AA - mA");
    }
}

class BB extends AA {
    public String str = "BB";
    @Override
    public void mA() {
        System.out.println("BB - mA");
    }
}