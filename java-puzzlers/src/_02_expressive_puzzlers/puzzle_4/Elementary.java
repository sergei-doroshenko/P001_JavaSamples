package _02_expressive_puzzlers.puzzle_4;

public class Elementary {
    public static void main(String[] args) {
        System.out.println(12345 + 5432l); // prints 17777, be aware of 'l' char
        System.out.println(12345 + 5432L); // prints 17777
        System.out.println(12345 + 54321); // prints 66666, be aware of 'l' char
    }

}
