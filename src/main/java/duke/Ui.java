package duke;

import duke.task.Task;

import java.util.List;
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

    public void showDivider() {
        System.out.println("----------------------------------");
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

    public void showFoundTasks(List<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:");
        listTasks(tasks);
    }

    public void listTasks(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i+1) + ". " + task);
        }
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
