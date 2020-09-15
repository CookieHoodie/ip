package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.List;

/**
 * Handles find command, which filters out tasks with the specified keyword.
 */
public class FindCommand extends Command {
    /**
     * Keyword to search for in the tasks.
     */
    private final String keyword;

    /**
     * @param keyword keyword to search for in the tasks
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Find the tasks that contain the keyword.
     *
     * @param tasks list of all the tasks
     * @param ui interface to print to
     * @param storage storage to save the tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> matchedTasks = tasks.find(keyword);
        ui.showFoundTasks(matchedTasks);
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
