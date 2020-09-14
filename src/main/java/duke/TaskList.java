package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i+1) + ". " + task);
        }
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task delete(int index) throws DukeException {
        try {
            return tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid index!");
        }

    }

    public Task markDone(int index) throws DukeException {
        try {
            Task doneTask = tasks.get(index);
            doneTask.setDone(true);
            return doneTask;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please provide a valid index!");
        }

    }

    public int size() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
