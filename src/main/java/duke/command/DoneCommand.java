package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

public class DoneCommand extends Command {
    private final int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task doneTask = tasks.markDone(index);
        ui.showTaskDone(doneTask);
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
