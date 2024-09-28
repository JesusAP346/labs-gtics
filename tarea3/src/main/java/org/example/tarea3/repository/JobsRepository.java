package org.example.tarea3.repository;

import org.example.tarea3.entity.Employees;
import org.example.tarea3.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,String> {

}
