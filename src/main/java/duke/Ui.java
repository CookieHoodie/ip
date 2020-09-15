package duke;

import duke.task.Task;

import java.util.List;
import java.util.Scanner;

/**
 * Handles the interface of the program.
 */
public class Ui {
    /**
     * Print welcome screen.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();
    }

    /**
     * Print error message.
     *
     * @param de DukeException error
     */
    public void showError(DukeException de) {
        System.out.println(de.getMessage());
    }

    /**
     * Print divider.
     */
    public void showDivider() {
        System.out.println("----------------------------------");
    }

    /**
     * Ask for user input and return it in unaltered form.
     *
     * @return user input
     */
    public String readCommand() {
        System.out.print("Command: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * Print indication that the task has been added to the list of tasks.
     *
     * @param taskList list of tasks
     * @param task task that has been added
     */
    public void showTaskAdded(TaskList taskList, Task task) {
        System.out.println("Got it. I've added this task:");
        // this will call the toString method of each child class
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    /**
     * Print indication that the task has been deleted from the list of tasks.
     *
     * @param taskList list of tasks
     * @param task task that has been deleted
     */
    public void showTaskDeleted(TaskList taskList, Task task) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    /**
     * Print indication that the task has been marked as done.
     *
     * @param task task that has been marked as done.
     */
    public void showTaskDone(Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
    }

    /**
     * Show results after finding tasks with the keyword specified.
     *
     * @param tasks filtered tasks that contain the keyword
     */
    public void showFoundTasks(List<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:");
        listTasks(tasks);
    }

    /**
     * List out the tasks given with corresponding indices
     *
     * @param tasks tasks to be printed to the screen
     */
    public void listTasks(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i+1) + ". " + task);
        }
    }

    /**
     * Print exit screen.
     */
    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
