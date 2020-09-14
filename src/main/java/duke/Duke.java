package duke;

import duke.command.Command;

import java.io.File;
import java.nio.file.Paths;

public class Duke {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    public Duke(File dukeFile) {
        ui = new Ui();
        storage = new Storage(dukeFile);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException de) {
            ui.showError(de);
            tasks = new TaskList();
        }
    }

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
                ui.showDivider();
            }
        }
    }

    public static void main(String[] args) {
        File dukeFile = Paths.get("data", "duke.txt").toFile();
        new Duke(dukeFile).run();
    }
}
