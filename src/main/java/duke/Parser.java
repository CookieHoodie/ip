package duke;

import duke.command.*;

/**
 * Handles parsing of user input to corresponding commands.
 */
public class Parser {
    /**
     * Parse the user input to corresponding commands depending on the keyword of the input.
     *
     * @param userInput raw user input
     * @return Command class corresponding to the type of keyword in the input
     * @throws DukeException If user input has the wrong format.
     */
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

    /**
     * Convert the 2nd argument of the user input to integer and return it.
     *
     * @param userInput raw user input
     * @return integer form of the argument, which should be an index
     * @throws DukeException If fails to convert the argument to integer or the input doesn't have an argument.
     */
    private static int getIndex(String userInput) throws DukeException {
        try {
            String[] tokens = userInput.split(" ");
            return Integer.parseInt(tokens[1]) - 1;  // -1 to convert to array index
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new DukeException("Please provide a valid index!");
        }
    }

    /**
     * Excludes command string and retrieves the rest of the user input
     *
     * @param userInput raw user input
     * @return user input excluding the command
     * @throws DukeException If the input doesn't have an argument.
     */
    private static String getTaskStr(String userInput) throws DukeException {
        try {
            String[] tokens = userInput.split(" ", 2);
            return tokens[1].strip();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid task name!");
        }
    }

    /**
     * Retrieves and returns the task name and the corresponding date/time from the cleaned input (without command string).
     * This should only be used for Deadline and Event tasks.
     *
     * @param taskStr cleaned input after excluding the command string
     * @param separator characters that the input should split from
     * @return an array of split input, which consists of the task name and date/time respectively
     * @throws DukeException If separator is not in the input or task name or date/time is empty.
     */
    private static String[] getTaskDetails(String taskStr, String separator) throws DukeException {
        String[] tokens = taskStr.split(separator, 2);
        if (tokens.length < 2) {
            throw new DukeException(separator + " must be specified in this command!");
        } else if (tokens[0].isBlank() || tokens[1].isBlank()) {
            throw new DukeException("Invalid task name or date.");
        }

        return tokens;
    }
}
