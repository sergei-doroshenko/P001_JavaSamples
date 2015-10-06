package behavioral.command;

import java.util.*;

/**
 * Created by Sergei on 09.09.2015.
 * --- Invoker ---
 */
public class Editor {
    Deque<Command> commands = new ArrayDeque<>();

    public void add(Command command) {
        commands.push(command);
        command.execute();
    }

    public void undo() {
        if (commands.size() > 0) {
            commands.pop().undo();
        }
    }
}
