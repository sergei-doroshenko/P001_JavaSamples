package behavioral.command;

import java.util.Scanner;

/**
 * Created by Sergei on 09.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Text text = new Text("In the town where I was born");
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands: [c] - cut, [p] - paste, [cp] - copy, [u] - undo");
        System.out.println("e.g. c 1 3");

        String line;
        while(true) {
            line = scanner.nextLine().trim();
            String[] parts = line.split(" ");

            if ( parts[0].equals("c") ) {
                editor.add(new CutCommand(text, Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));

            } else if ( parts[0].equals("p") ) {
                editor.add(new PasteCommand(text, Integer.valueOf(parts[1])));

            } else if ( parts[0].equals("cp") ) {
                editor.add(new CopyCommand(text, Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));

            } else if ( parts[0].equals("u") ) {
                editor.undo();
            } else {
                System.out.println("Unknown command.");
            }

            System.out.println(text);
        }
    }
}
