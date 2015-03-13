package _7_inheritance;

/**
 * Created by Sergei on 10.03.2015.
 */
public class App04 {
    public static void main(String[] args){
        System.out.println(Sub.ID);
    }
}

class Super { static String ID = "QBANK"; }

class Sub extends Super{
    static { System.out.print("In Sub"); }
}
