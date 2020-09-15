package duke.task;

/**
 * Represent deadline task, which has a deadline.
 */
public class Deadline extends Task {
    /**
     * Deadline of the task.
     */
    private String by;

    /**
     * @param taskName name of the deadline task
     * @param by deadline of the task
     */
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
