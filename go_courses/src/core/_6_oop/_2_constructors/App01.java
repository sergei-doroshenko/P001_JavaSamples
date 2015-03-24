package core._6_oop._2_constructors;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        class TT {
            TT(){
                System.out.println("TT()");
            }
        }

        TT t0 = new TT();
        Class<? extends TT> clazz = t0.getClass();
        TT t1 = clazz.newInstance(); // !!! Call TT's constructor !!!
    }



}
