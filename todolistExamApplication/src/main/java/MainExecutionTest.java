import model.Task;
import org.hibernate.SessionFactory;
import service.ToDoListService;

import java.sql.Date;
import java.util.Scanner;

public class MainExecutionTest {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter task date (yyyy-mm-dd): ");
            String dateInput = scanner.nextLine();
            Date date = Date.valueOf(dateInput);

            System.out.print("Enter task name: ");
            String taskName = scanner.nextLine();

            System.out.print("Enter task description: ");
            String description = scanner.nextLine();

            System.out.print("Enter task duration: ");
            int duration = scanner.nextInt();

            // Create a Task object with the retrieved details
            Task task = new Task();
            task.setTaskName(taskName);
            task.setTaskDate(date);
            task.setTaskDescription(description);
            task.setTaskDuration(duration);

            // Save the task using the ToDoListService
            ToDoListService toDoListService = new ToDoListService(sessionFactory); // Pass null for the SessionFactory in testing
            toDoListService.saveToDoTask(task);

            System.out.println("Task added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
