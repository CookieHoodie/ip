import java.util.Scanner;

public class Duke {
    private static Task[] taskList = new Task[100];
    private static int taskNum = 0;

    /**
     * Process user input and do corresponding task specified.
     *
     * @param command   the user input
     * @return          true if the program should exit, false if otherwise
     */
    private static boolean processCommand(String command) throws DukeException {
        command = command.strip();  // ensure commands don't get affected by extra spaces

        if (command.equals("bye")) {
            return true;
        } else if (command.equals("list")) {
            for (int i = 0; i < taskNum; i++) {
                Task task = taskList[i];
                System.out.println((i+1) + ". " + task);
            }
        } else if (command.startsWith("done")) {
            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[1]) - 1;  // -1 to convert to array index
            Task doneTask = taskList[index];
            doneTask.setDone(true);
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(doneTask);
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
            taskList[taskNum] = newTask;
            taskNum++;
            System.out.println("Now you have " + taskNum + " tasks in the list.");
        } else {  // unknown commands
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }

        return false;
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
