package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task deletedTask = tasks.delete(index);
        storage.storeTasks(tasks.getTasks());
        ui.showTaskDeleted(tasks, deletedTask);
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
