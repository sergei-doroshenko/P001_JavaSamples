package core._0_proc._0_folklore;

/**
 * Created by Sergei on 22.03.2015.
 */
public class App01Increment {
    public static void main(String[] args) {
        int z = 5;
        z = z++ + ++z; //12
        System.out.println("z = " + z);
    }
}
