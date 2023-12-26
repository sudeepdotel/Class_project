package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Task;
import service.ToDoListService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import static util.HibernateUtils.sessionFactory;

@WebServlet("/getTasksByDate")
public class ToDoListServlet extends HttpServlet {

    private ToDoListService toDoListService;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ToDoListService toDoListService = new ToDoListService(sessionFactory);
        // Retrieve date from the request parameters
        Date date = Date.valueOf(request.getParameter("searchDate"));

        // Get tasks for the specified date
        List<Task> tasks = toDoListService.getTasksByDate(date);

        // Display tasks directly in the servlet
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Tasks for Date</title></head><body>");
        response.getWriter().println("<h2>Tasks for Date</h2>");
        response.getWriter().println("<table border=\"1\">");
        response.getWriter().println("<tr><th>Task ID</th><th>Task Name</th><th>Task Date</th><th>Task Description</th><th>Task Duration(in hr)</th></tr>");

        for (Task task : tasks) {
            response.getWriter().println("<tr>");
            response.getWriter().println("<td>" + task.getTaskId() + "</td>");
            response.getWriter().println("<td>" + task.getTaskName() + "</td>");
            response.getWriter().println("<td>" + task.getTaskDate() + "</td>");
            response.getWriter().println("<td>" + task.getTaskDescription() + "</td>");
            response.getWriter().println("<td>" + task.getTaskDuration() + "</td>");
            response.getWriter().println("</tr>");
        }

        response.getWriter().println("</table></body></html>");
    }
}
