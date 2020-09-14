package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Event;

/**
 * Handles event command, which adds a task with corresponding event date/time.
 */
public class EventCommand extends Command {
    /**
     * Event task name.
     */
    private final String eventName;
    /**
     * Date/time for the event.
     */
    private final String eventTime;

    /**
     * @param eventName event task name
     * @param eventTime date/time for the event
     */
    public EventCommand(String eventName, String eventTime) {
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    /**
     * Add a new event task to the list of tasks and store them to local storage. This method also prints out the result
     * to the interface.
     *
     * @param tasks   list of all the tasks
     * @param ui      interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If fails to save to local storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Event event = new Event(eventName, eventTime);
        tasks.add(event);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskAdded(tasks, event);
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
