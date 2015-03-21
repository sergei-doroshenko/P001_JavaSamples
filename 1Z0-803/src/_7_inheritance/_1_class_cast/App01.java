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
        AA ref4 = (AA) (IntA) ref0;
        BB ref5 = (BB) (IntA) ref4;

        BB ref6 = (BB) (IntB) ref4;
        IntB ref7 = (IntB) (AA) ref6;
    }
}

interface IntA {}
interface IntB {}

class AA implements IntA {}

class BB extends AA {}