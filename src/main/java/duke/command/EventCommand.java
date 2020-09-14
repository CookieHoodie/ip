package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Event;

public class EventCommand extends Command {
    private final String eventName;
    private final String eventTime;

    public EventCommand(String eventName, String eventTime) {
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event event = new Event(eventName, eventTime);
        tasks.add(event);
        ui.showTaskAdded(tasks, event);
        ui.readCommand();
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
