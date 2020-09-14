package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Handles delete command, which deletes the specified task from the list of tasks.
 */
public class DeleteCommand extends Command {
    /**
     * Index of task to be deleted.
     */
    private final int index;

    /**
     * @param index index of task to be deleted
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Delete task at the index from the list of tasks. This method also prints out the result to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If fails to delete the task at the index, or fails to save to the local storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task deletedTask = tasks.delete(index);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskDeleted(tasks, deletedTask);
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
