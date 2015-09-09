package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public class PasteCommand implements Command {
    private Text text;
    private String buffer;

    public PasteCommand(Text text) {
        this.text = text;
    }

    @Override
    public void execute() {
        buffer = text.getFromBuffer();
        text.paste(buffer);
    }

    @Override
    public void undo() {
        text.undoPaste(buffer);
        buffer = null;
    }
}
