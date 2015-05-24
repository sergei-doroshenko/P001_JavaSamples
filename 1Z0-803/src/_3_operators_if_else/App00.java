package _3_operators_if_else;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        int a = 8;
        int b = ++a + a + a--;
        System.out.println(b); // 27
        System.out.println(a); // 8

        int i = 1; int j = i++;         // j is assigned 1 and i is incremented to 2
        if( (i == ++j) | (i++ == j) ) {   // increment j (so j becomes 2) and compare with i => return true.  
                                        // since it is |, evaluate next condition: compare i with 2 and increment i => i becomes 3.
            i+=j;                       //i = 3+2 = 5
        }
        System.out.println(i); //prints 5

        int c1 = 3;
        int c2 = (c1 =+ 4); // c2 = 7
        int c3 = (c3 = c1 + c2); // c3 = 10
        boolean bool = (c1 = c2 - 10) < (c1 = c3 + c2++); // true
        System.out.printf("c1=%d c2=%d c3=%d bool=%s\n", c1, c2, c3, bool); // c1=12 c2=5 c3=8 bool=true

        int x0, x1, x2, x3;
        x0 = x1 = x2 = x3 = 1;
        System.out.printf("x0=%d x1=%d x2=%d x3=%d\n", x0, x1, x2, x3);

        int k = 1;
        k += 3 + ++k; // 6
        System.out.println("k = " + k); // 6

        int a0 = 10;
        int b0 = 20;
        a0 += (a0 = 4);     // Listing_14_14 ---> a0 = a0 + (a0 = 4) -> a0 = 10 + (a0 = 4) -> a0 = 10 + 4 = Listing_14_14
        b0 = b0 + (b0 = 5); // 25 ---> b0 = 20 + (b0 = 5)             ->           b0 = 20 + 5 = 25
        System.out.println(a0 + ",  " + b0);

    }
}
