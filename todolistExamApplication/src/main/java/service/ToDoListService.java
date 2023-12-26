package service;

import dao.ToDoListDAO;
import model.Task;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.List;

public class ToDoListService {

    private final ToDoListDAO toDoListDAO;

    public ToDoListService( SessionFactory sessionFactory) {
        this.toDoListDAO = new ToDoListDAO (sessionFactory);
    }

    public void saveToDoTask( Task task) {
        toDoListDAO.saveToDoTask(task);
    }

    public List<Task> getTasksByDate( Date date) {
        return toDoListDAO.getTasksByDate(date);
    }
}
