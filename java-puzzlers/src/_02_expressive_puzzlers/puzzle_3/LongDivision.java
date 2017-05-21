package _02_expressive_puzzlers.puzzle_3;

public class LongDivision {
    public static void main(String[] args) {
        /*The computation is performed entirely in int arithmetic*/
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY); // prints 5

        final long MICROS_PER_DAY_L = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY_L = 24L * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY_L / MILLIS_PER_DAY_L); // prints 1000
    }
}
