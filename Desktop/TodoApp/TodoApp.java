import java.util.*;
import java.io.*;

public class TodoApp {
    static List<String> tasks = new ArrayList<>();
    static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        loadTasks();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List:");
            showTasks();
            System.out.println("\nOptions: [1] Add  [2] Remove  [3] Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    saveTasks();
                    break;
                case "2":
                    System.out.print("Enter task number to remove: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index >= 1 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        saveTasks();
                    } else {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("  No tasks.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.println(task);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    static void loadTasks() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                tasks.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // First time run — ignore
        }
    }
}
