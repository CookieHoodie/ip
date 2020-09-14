package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;

public class DeadlineCommand extends Command {
    private final String deadlineName;
    private final String deadline;

    public DeadlineCommand(String deadlineName, String deadline) {
        this.deadlineName = deadlineName;
        this.deadline = deadline;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Deadline dl = new Deadline(deadlineName, deadline);
        tasks.add(dl);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskAdded(tasks, dl);
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
