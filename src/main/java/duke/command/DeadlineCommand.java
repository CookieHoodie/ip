package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;

/**
 * Handles deadline command, which adds a task with corresponding deadline.
 */
public class DeadlineCommand extends Command {
    /**
     * Deadline task name.
     */
    private final String deadlineName;
    /**
     * Deadline for the task.
     */
    private final String deadline;

    /**
     * @param deadlineName deadline task name
     * @param deadline deadline for the task
     */
    public DeadlineCommand(String deadlineName, String deadline) {
        this.deadlineName = deadlineName;
        this.deadline = deadline;
    }

    /**
     * Add a new deadline task to the list of tasks and store them to local storage. This method also prints out the
     * result to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If fails to save to local storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Deadline dl = new Deadline(deadlineName, deadline);
        tasks.add(dl);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskAdded(tasks, dl);
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
