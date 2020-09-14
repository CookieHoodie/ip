package duke;

import duke.task.Task;

import java.util.Scanner;

public class Ui {
    public void showWelcome() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();
    }

    public void showError(DukeException de) {
        System.out.println(de.getMessage());
    }

    public String readCommand() {
        System.out.print("Command: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void showTaskAdded(TaskList taskList, Task task) {
        System.out.println("Got it. I've added this task:");
        // this will call the toString method of each child class
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void showTaskDeleted(TaskList taskList, Task task) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void showTaskDone(Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
