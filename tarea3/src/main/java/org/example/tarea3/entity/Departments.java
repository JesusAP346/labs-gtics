package org.example.tarea3.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer department_id;

    private String department_name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;


}
