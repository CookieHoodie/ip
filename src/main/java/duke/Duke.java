package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static List<Task> taskList = new ArrayList<>();

    private static void listTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println((i+1) + ". " + task);
        }
    }

    /**
     * Get the index after commands. If the command argument is not number, exception will be thrown
     * @param command  command along with number as the only argument
     */
    private static int getCommandIndex(String command) {
        String[] tokens = command.split(" ");
        return Integer.parseInt(tokens[1]) - 1;  // -1 to convert to array index
    }

    private static void markDone(int index) {
        Task doneTask = taskList.get(index);
        doneTask.setDone(true);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(doneTask);
    }

    private static void markDeleted(int index) {
        Task deletedTask = taskList.get(index);
        taskList.remove(index);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(deletedTask);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    /**
     * Process user input and do corresponding task specified.
     *
     * @param command   the user input
     * @return          true if the program should exit, false if otherwise
     */
    private static boolean processCommand(String command) throws DukeException {
        boolean shouldExit = false;
        command = command.strip();  // ensure commands don't get affected by extra spaces

        if (command.equals("bye")) {
            shouldExit = true;
        } else if (command.equals("list")) {
            listTasks();
        } else if (command.startsWith("done")) {
            int index = getCommandIndex(command);
            markDone(index);
        } else if (command.startsWith("delete")) {
            int index = getCommandIndex(command);
            markDeleted(index);
        } else if (command.startsWith("todo") || command.startsWith("deadline")
                || command.startsWith("event")) {
            String[] tokens = command.split(" ", 2);
            Task newTask = null;  // to be stored into the taskList later

            if (tokens.length < 2) {  // commands without parameters
                throw new DukeException("The description of a " + tokens[0] + " cannot be empty.");
            }

            if (tokens[0].equals("todo")) {
                newTask = new Todo(tokens[1].strip());
            } else if (tokens[0].equals("deadline")) {
                String[] taskAndDate = tokens[1].split("/by");
                if (taskAndDate.length < 2) {
                    throw new DukeException("/by is not specified in the deadline.");
                }
                newTask = new Deadline(taskAndDate[0].strip(), taskAndDate[1].strip());
            } else if (tokens[0].equals("event")) {
                String[] taskAndDate = tokens[1].split("/at");
                if (taskAndDate.length < 2) {
                    throw new DukeException("/at is not specified in the event.");
                }
                newTask = new Event(taskAndDate[0].strip(), taskAndDate[1].strip());
            }

            System.out.println("Got it. I've added this task:");
            // this will call the toString method of each child class
            System.out.println(newTask);
            taskList.add(newTask);
            System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        } else {  // unknown commands
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }

        return shouldExit;
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();

        String command;
        while (true) {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();

            try {
                boolean shouldExit = processCommand(command);
                if (shouldExit) {
                    break;
                }
            } catch (DukeException de) {
                System.out.println(de.getMessage());
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}