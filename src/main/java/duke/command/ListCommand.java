package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Handles list command, which list out all the tasks in the list.
 */
public class ListCommand extends Command {

    /**
     * Print out all the tasks in the list.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.listTasks(tasks.getTasks());
    }

    /**
     * {@inheritDoc}
     *
     * @return false
     */
    @Override
    public boolean shouldExit() {
        return false;
    }
}
