package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Text text = new Text("Hello mr. Bond.");
        System.out.println(text);

        editor.add(new CutCommand(text, "Bond."));
        System.out.println(text);

        editor.add(new CopyCommand(text, "mr."));
        System.out.println(text);

        editor.add(new PasteCommand(text));
        System.out.println(text);

//        System.out.println(text);

        editor.undo();
        System.out.println(text);

        editor.undo();
        System.out.println(text);

        editor.undo();
        System.out.println(text);
    }
}
