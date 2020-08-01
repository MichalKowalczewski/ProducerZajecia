package com.example.producer.service;


import com.example.producer.model.dto.TaskDTO;
import com.example.producer.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<TaskDTO> findAll() {
        return repository.findAll().stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }
}
