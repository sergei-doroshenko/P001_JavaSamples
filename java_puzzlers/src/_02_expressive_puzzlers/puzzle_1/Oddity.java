package _02_expressive_puzzlers.puzzle_1;

public class Oddity {
    // (a / b) * b + (a % b) == a
    /* When i is a negative odd number, i % 2 is equal to -1 rather than 1, so the
    isOdd method incorrectly returns false. */
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }


    public static boolean isOddFixed(int i) {
        return i % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(3)); // true
        System.out.println(isOdd(-3)); // false

        System.out.println(isOddFixed(3)); // true
        System.out.println(isOddFixed(-3)); // true
    }
}
