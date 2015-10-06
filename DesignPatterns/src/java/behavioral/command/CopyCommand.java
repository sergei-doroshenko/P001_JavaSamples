package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class CopyCommand implements Command {
    private Text text;
    private int start, length;

    public CopyCommand(Text text, int start, int length) {
        if (start < 0 || length > text.size() - start) {
            throw new IllegalStateException("Wrong indexes");
        }
        this.text = text;
        this.start = start;
        this.length = length;
    }

    @Override
    public void execute() {
        text.getBuffer().push(text.getPart(start, length));
    }

    @Override
    public void undo() {
        if (text.getBuffer().size() > 0) {
            text.getBuffer().pop();
        } else {
            System.out.println("Can't undo copy command");
        }

    }
}
