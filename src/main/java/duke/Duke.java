package duke;

import duke.command.Command;

import java.io.File;
import java.nio.file.Paths;

/**
 * Duke program.
 */
public class Duke {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    /**
     * Instantiate different components of the program (interface, storage, and tasks).
     *
     * @param dukeFile file to load the task data from
     */
    public Duke(File dukeFile) {
        ui = new Ui();
        storage = new Storage(dukeFile);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException de) {
            ui.showError(de);
            tasks = new TaskList();  // initialize to new list if no data exists yet
        }
    }

    /**
     * Method that runs the program.
     */
    public void run() {
        ui.showWelcome();
        boolean shouldExit = false;
        while (!shouldExit) {
            String userInput = ui.readCommand();
            try {
                Command command = Parser.parse(userInput);
                command.execute(tasks, ui, storage);
                shouldExit = command.shouldExit();
            } catch (DukeException de) {
                ui.showError(de);
            } finally {
                ui.showDivider();  // for better ui experience
            }
        }
    }

    public static void main(String[] args) {
        File dukeFile = Paths.get("data", "duke.txt").toFile();
        new Duke(dukeFile).run();  // initiate and run the duke program.
    }
}
