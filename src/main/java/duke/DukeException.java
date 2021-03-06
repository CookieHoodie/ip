package duke;

/**
 * Exception class to be used in Duke program. This exceptions adds a prefix (greeting) to every error message.
 */
public class DukeException extends Exception {
    public DukeException(String errorMessage, Throwable err) {
        super(greeting() + errorMessage, err);
    }

    public DukeException(String errorMessage) {
        super(greeting() + errorMessage);
    }

    private static String greeting() {
        return "☹ OOPS!!! ";
    }
}
