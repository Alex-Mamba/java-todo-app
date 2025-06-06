import java.util.ArrayList;

public class TodoApp {
    static class Task {
        String title;
        boolean isDone;

        Task(String title) {
            this.title = title;
            this.isDone = false;
        }

        void markDone() {
            isDone = true;
        }

        @Override
        public String toString() {
            return (isDone ? "[x] " : "[ ] ") + title;
        }
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Study for math"));

        tasks.get(0).markDone();

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
