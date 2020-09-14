package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.List;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        List<Task> matchedTasks = tasks.find(keyword);
        ui.showFoundTasks(matchedTasks);
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
