public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
    public String toDataString() {
    return description + "," + isCompleted;
    }

// Creates a Task from a line in the file
    public static Task fromDataString(String line) {
    String[] parts = line.split(",", 2);
    Task task = new Task(parts[0]);
    if (parts.length > 1 && Boolean.parseBoolean(parts[1])) {
        task.markCompleted();
    }
    return task;
    }
}