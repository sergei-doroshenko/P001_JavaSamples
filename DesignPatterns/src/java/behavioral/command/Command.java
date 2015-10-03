package behavioral.command;

/**
 * Created by Sergei on 09.09.2015.
 */
public interface Command {
    void execute();

    void undo();
}
