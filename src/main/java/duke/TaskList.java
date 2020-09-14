package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles operations on the underlying List structure.
 */
public class TaskList {
    /**
     * List that stores the tasks for the program.
     */
    private List<Task> tasks;

    /**
     * Creates an empty ArrayList as task storage.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Takes in an existing list (may or may not be filled) as task storage.
     *
     * @param tasks list of existing tasks
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i+1) + ". " + task);
        }
    }

    /**
     * Add task to the list.
     *
     * @param task task to be added to the list
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Delete the task at the index from the list.
     *
     * @param index index of task in the list
     * @return the deleted task
     * @throws DukeException If the index is not in range of the list size.
     */
    public Task delete(int index) throws DukeException {
        try {
            return tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid index!");
        }

    }

    /**
     * Mark the task at the index as done.
     *
     * @param index index of task in the list
     * @return the task that is marked as done
     * @throws DukeException If the index is not in range of the list size.
     */
    public Task markDone(int index) throws DukeException {
        try {
            Task doneTask = tasks.get(index);
            doneTask.setDone(true);
            return doneTask;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid index!");
        }

    }

    /**
     * @return number of tasks in the list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * @return the underlying list
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
