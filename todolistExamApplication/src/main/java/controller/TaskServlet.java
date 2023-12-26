package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Task;
import org.hibernate.SessionFactory;
import service.ToDoListService;
import util.HibernateUtils;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/addTask")
public class TaskServlet extends HttpServlet {

    private SessionFactory sessionFactory;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve task details from the request parameters
        Date date = Date.valueOf(request.getParameter("taskDate"));
        String taskName = request.getParameter("taskName");
        String description = request.getParameter("taskDescription");
        int duration = Integer.parseInt(request.getParameter("taskDuration"));



        // Create a Task object with the retrieved details
        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskDate ( date );
        task.setTaskDescription (description);
        task.setTaskDuration (duration);

        // Save the task using the ToDoListService
        ToDoListService toDoListService = new ToDoListService(sessionFactory);
        toDoListService.saveToDoTask(task);

        response.getWriter().println("Task added successfully!");
    }
}
