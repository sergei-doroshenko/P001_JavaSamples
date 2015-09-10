package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class CutCommand implements Command {
    private Text text;
    private int start, length;

    public CutCommand(Text text, int start, int length) {
        if (start < 0 || length > text.size() - start) {
            throw new IllegalStateException("Wrong indexes");
        }
        this.text = text;
        this.start = start;
        this.length = length;
    }

    @Override
    public void execute() {
        text.delete(this.start, start + length);
    }

    @Override
    public void undo() {
        text.insert(this.start);
    }
}
