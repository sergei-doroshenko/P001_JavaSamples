package _4_arrays;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App02 {

    public static int[] getArray() { return null; }

    public static void main(String[] args) {
        int index = 1;
        try{
            getArray()[index=2]++;
        } catch (Exception e){ } //empty catch
        System.out.println("index = " + index);
    }
}
