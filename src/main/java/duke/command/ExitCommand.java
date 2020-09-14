package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Handles exit command, which terminates the program.
 */
public class ExitCommand extends Command {
    /**
     * Prints out exit screen to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExit();
    }

    /**
     * {@inheritDoc}
     *
     * @return true
     */
    @Override
    public boolean shouldExit() {
        return true;
    }
}
