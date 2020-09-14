package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Handles done command, which marks the specified task as done.
 */
public class DoneCommand extends Command {
    /**
     * Index of task to be marked as done.
     */
    private final int index;

    /**
     * @param index index of task to be marked as done
     */
    public DoneCommand(int index) {
        this.index = index;
    }

    /**
     * Mark the task at the index to done. This method also prints out the result to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If fails to mark the task at the index, or fails to save to local storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task doneTask = tasks.markDone(index);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskDone(doneTask);
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
