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
    private static boolean processCommand(String command) {
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
            System.out.println("Got it. I've added this task:");

            String[] tokens = command.split(" ", 2);
            Task newTask = null;  // to be stored into the taskList later

            if (tokens[0].equals("todo")) {
                newTask = new Todo(tokens[1].strip());
            } else if (tokens[0].equals("deadline")) {
                String[] taskAndDate = tokens[1].split("/by");
                newTask = new Deadline(taskAndDate[0].strip(), taskAndDate[1].strip());
            } else if (tokens[0].equals("event")) {
                String[] taskAndDate = tokens[1].split("/at");
                newTask = new Event(taskAndDate[0].strip(), taskAndDate[1].strip());
            }

            // this will call the toString method of each child class
            System.out.println(newTask);
            taskList[taskNum] = newTask;
            taskNum++;
            System.out.println("Now you have " + taskNum + " tasks in the list.");
        } else {  // for commands that are not in the lists, treat them as unclassified tasks.
            System.out.println("added: " + command);
            Task newTask = new Task(command);
            taskList[taskNum] = newTask;
            taskNum++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();

        String command;
        do {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();

        } while (!processCommand(command));

        System.out.println("Bye. Hope to see you again soon!");
    }
}
