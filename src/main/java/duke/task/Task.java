package duke.task;

import java.io.Serializable;

/**
 * Base class for more specific type of classes. Contains basic information such as task name and whether the task is done.
 */
public class Task implements Serializable {
    /**
     * Name of the task.
     */
    private final String name;
    /**
     * Whether the task is done.
     */
    private boolean isDone;

    /**
     * @param name name of the task
     * @param isDone whether the task is done
     */
    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * This constructor sets the task status to not done.
     *
     * @param name name of the task
     */
    public Task(String name) {
        this(name, false);
    }

    /**
     * Returns corresponding icons depending on the status of the task.
     *
     * @return tick icon if the task is done, cross icon if not
     */
    public String getStatusIcon() {
        if (isDone) {
            return "[✓]";
        } else {
            return "[✗]";
        }
    }

    public String getName() {
        return name;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getName();
    }
}
