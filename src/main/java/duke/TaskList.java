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

    /**
     * Find tasks that contain the keyword.
     *
     * @param keyword keyword to search in the task names
     * @return a list of tasks that contain the keyword
     */
    public List<Task> find(String keyword) {
        List<Task> matchedTasks = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getName().contains(keyword)) {
                matchedTasks.add(t);
            }
        }

        return matchedTasks;
    }

    public int size() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
