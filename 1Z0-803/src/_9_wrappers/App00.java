package _9_wrappers;

/**
 * Created by Sergei on 06.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper + value);

        System.out.println(new Integer(10) + new Integer(20)); // prints 30
    }

    public static Integer wiggler(Integer x){
        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }
}

/*
6 20
*/
