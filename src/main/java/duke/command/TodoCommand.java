package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Todo;

public class TodoCommand extends Command {
    private final String taskName;

    public TodoCommand(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo task = new Todo(taskName);
        tasks.add(task);
        ui.showTaskAdded(tasks, task);
        ui.readCommand();
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
