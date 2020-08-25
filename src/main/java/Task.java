public class Task {
    private final String name;
    private boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public Task(String name) {
        this(name, false);
    }

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
}
