package duke;

import duke.command.*;

public class Parser {
    public static Command parse(String userInput) throws DukeException {
        userInput = userInput.strip();  // ensure commands don't get affected by extra spaces
        if (userInput.equals("bye")) {
            return new ExitCommand();
        } else if (userInput.equals("list")) {
            return new ListCommand();
        } else if (userInput.startsWith("done")) {
            return new DoneCommand(getIndex(userInput));
        } else if (userInput.startsWith("delete")) {
            return new DeleteCommand(getIndex(userInput));
        } else if (userInput.startsWith("todo")) {
            return new TodoCommand(getTaskStr(userInput));
        } else if (userInput.startsWith("event")) {
            String taskStr = getTaskStr(userInput);
            String[] details = getTaskDetails(taskStr, "/at");
            return new EventCommand(details[0], details[1]);
        } else if (userInput.startsWith("deadline")) {
            String taskStr = getTaskStr(userInput);
            String[] details = getTaskDetails(taskStr, "/by");
            return new DeadlineCommand(details[0], details[1]);
        }

        // invalid command
        throw new DukeException("I'm sorry, but I don't know what that means :-(");
    }

    private static int getIndex(String userInput) throws DukeException {
        try {
            String[] tokens = userInput.split(" ");
            return Integer.parseInt(tokens[1]) - 1;  // -1 to convert to array index
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new DukeException("Please provide a valid index!");
        }
    }

    private static String getTaskStr(String userInput) throws DukeException {
        try {
            String[] tokens = userInput.split(" ", 2);
            return tokens[1].strip();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid task name!");
        }
    }

    private static String[] getTaskDetails(String taskStr, String separator) throws DukeException {
        String[] tokens = taskStr.split(separator, 2);
        if (tokens.length < 2) {
            throw new DukeException(separator + "must be specified in this command!");
        }

        return tokens;
    }
}
