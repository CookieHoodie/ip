import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();

        String command;
        Task[] taskList = new Task[100];
        int taskNum = 0;
        while (true) {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();

            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                for (int i = 0; i < taskNum; i++) {
                    Task task = taskList[i];
                    System.out.println((i+1) + ". " + task.getStatusIcon() + " " + task.getName());
                }
            } else if (command.startsWith("done")) {
                String[] tokens = command.split(" ");
                int index = Integer.parseInt(tokens[1]) - 1;  // -1 to convert to array index
                Task doneTask = taskList[index];
                doneTask.setDone(true);
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(doneTask.getStatusIcon() + " " + doneTask.getName());
            } else {
                System.out.println("added: " + command);
                Task newTask = new Task(command);
                taskList[taskNum] = newTask;
                taskNum++;
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
