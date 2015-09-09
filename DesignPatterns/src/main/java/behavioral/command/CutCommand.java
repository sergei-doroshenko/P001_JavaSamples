package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class CutCommand implements Command {
    private Text text;
    private String buffer;

    public CutCommand(Text text, String str) {
        this.text = text;
        this.buffer = str;
    }

    @Override
    public void execute() {
        text.cut(buffer);
        buffer = null;
    }

    @Override
    public void undo() {
        buffer = text.getFromBuffer();
        text.paste(buffer);
    }
}
