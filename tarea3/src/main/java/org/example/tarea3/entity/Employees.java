package org.example.tarea3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employee_id;


    private String first_name;
    private String last_name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    private Double salary;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;


}
