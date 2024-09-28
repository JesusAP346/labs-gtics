package org.example.tarea2.repository;

import org.example.tarea2.entity.Departments;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer>  {

}
