package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class CopyCommand implements Command {
    private Text text;
    private String buffer;

    public CopyCommand(Text text, String str) {
        this.text = text;
        this.buffer = str;
    }

    @Override
    public void execute() {
        text.copy(buffer);
    }

    @Override
    public void undo() {
        if (buffer.equals(text.getBuffer().peek())) {
            buffer = text.getFromBuffer();
        }
    }
}
