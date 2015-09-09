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

    public void cut(String str) {
        buffer.push(str);
        textSource = textSource.replaceFirst(str, "");
    }

    public void copy(String str) {
        buffer.push(str);
    }

    public void paste(String str) {
        textSource += str;
    }

    public String getFromBuffer() {
        return buffer.pop();
    }

    public Deque<String> getBuffer() {
        return buffer;
    }

    public void undoPaste(String str) {
        textSource = textSource.replaceFirst(str, "");
    }

    @Override
    public String toString() {
        return textSource;
    }
}
