package org.example.tarea3.repository;

import org.example.tarea3.entity.Departments;
import org.example.tarea3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {
}
