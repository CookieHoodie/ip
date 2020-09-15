package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Todo;

/**
 * Handles todo command, which adds a todo task.
 */
public class TodoCommand extends Command {
    /**
     * Todo task name.
     */
    private final String taskName;

    /**
     * @param taskName todo task name
     */
    public TodoCommand(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Add a new todo task to the list of tasks and store them to local storage. This method also prints out the result
     * to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If fails to save to local storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Todo task = new Todo(taskName);
        tasks.add(task);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskAdded(tasks, task);
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
