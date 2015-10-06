package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class PasteCommand implements Command {
    private Text text;
    private int start, end;

    public PasteCommand(Text text, int start) {
        if (start < 0) {
            throw new IllegalStateException("Wrong indexes");
        }
        this.text = text;
        this.start = start;
    }

    @Override
    public void execute() {
        end = text.insert(start);
    }

    @Override
    public void undo() {
        text.delete(start, end);
    }
}
