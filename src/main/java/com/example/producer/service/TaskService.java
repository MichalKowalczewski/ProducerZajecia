package com.example.producer.service;

import com.example.producer.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAll();
    TaskDTO findById(Integer id);
    TaskDTO create(TaskDTO task);
    TaskDTO findLast();
    TaskDTO update(Integer id,TaskDTO task);
}
