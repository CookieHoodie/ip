package duke.task;

/**
 * Represent event task, which has a date/time component.
 */
public class Event extends Task {
    /**
     * Date/time of the event.
     */
    private String at;

    /**
     * @param taskName name of the event
     * @param at date/time of the event
     */
    public Event(String taskName, String at) {
        super(taskName);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
