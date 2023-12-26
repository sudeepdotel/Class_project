package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@Entity
@Table(name = "tasks")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;


    @Column(name="task_name")
    private String taskName;

    @Column(name = "task_date")
    private Date taskDate;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "task_duration")
    private int taskDuration;



    public Task() {
    }

    public Task(Date taskDate, String taskName,String taskDescription, int taskDuration) {
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
    }
}
