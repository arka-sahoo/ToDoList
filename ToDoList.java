import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Options:");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewTasks();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    removeTask();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewTasks() {
        System.out.println("\n Current Tasks: ");
        String task = scanner.nextLine();
        if (task.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added: \"" + task + "\"");
        } else {
            System.out.println("Task cannot be empty");
        }
    }

    private static void removeTask() {
        viewTasks();
        if (tasks.isEmpty()) {
            return;
        }
        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task removed: \"" + removedTask + "\"");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}