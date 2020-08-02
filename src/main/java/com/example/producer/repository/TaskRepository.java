package com.example.producer.repository;

import com.example.producer.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findFirstByOrderByIdDesc();

}
