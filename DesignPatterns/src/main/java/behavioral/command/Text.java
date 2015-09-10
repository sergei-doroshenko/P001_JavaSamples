package behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Sergei on 09.09.2015.
 * --- Receiver ---
 */
public class Text {
    private String textSource;
    private Deque<String> buffer = new ArrayDeque<>();

    public Text(String textSource) {
        this.textSource = textSource;
    }

    public int size() {
        return textSource.length();
    }

    public Deque<String> getBuffer() {
        return buffer;
    }

    public String getPart(int start, int length) {
        String part = textSource.substring(start, start + length);
//        System.out.println("getPart, part: " + part);
        return part;
    }

    public int insert(int start) {
        if (buffer.size() > 0) {
            String part = buffer.pop();
//            System.out.println("insert, part: " + part);

            textSource = textSource.substring(0, start) +
                    part +
                    textSource.substring(start, textSource.length());
//            System.out.println("insert, textSource: " + textSource);

            return start + part.length();
        } else {
            System.out.println("Nothing to insert");
            return -1;
        }
    }

    public void delete(int start, int end) {
        String part = textSource.substring(start, end);
//        System.out.println("delete, part: " + part);

        buffer.push(part);
//        System.out.println("delete, buffer: " + buffer);

        textSource = textSource.substring(0, start) +
                textSource.substring(end, textSource.length());

//        System.out.println("delete, textSource: " + this);
    }

    @Override
    public String toString() {
        return textSource;
    }
}
