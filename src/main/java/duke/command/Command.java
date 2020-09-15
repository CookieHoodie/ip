package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Represents user command.
 */
public abstract class Command {
    /**
     * Execute actions that correspond to the command.
     *
     * @param tasks list of all the tasks
     * @param ui interface to print to
     * @param storage storage to save the tasks
     * @throws DukeException If command execution goes wrong.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Returns back flag to the main program to specify if the program should exit.
     *
     * @return true if the program should exit after executing current command, false if not.
     */
    public abstract boolean shouldExit();
}
