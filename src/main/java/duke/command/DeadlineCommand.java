package duke.command;

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
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline dl = new Deadline(deadlineName, deadline);
        tasks.add(dl);
        ui.showTaskAdded(tasks, dl);
        ui.readCommand();
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
