package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@ToString
@Entity
@Table(name = "expenses")
public class DailyExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "expense_name")
    private String expenseName;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "amount")
    private double amount;



}