import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String FILE_NAME = "tasks.txt";

    public static void saveTasks(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.toDataString());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromDataString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }
}

