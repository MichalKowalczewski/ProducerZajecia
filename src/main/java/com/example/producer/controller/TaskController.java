package com.example.producer.controller;

import com.example.producer.model.dto.TaskDTO;
import com.example.producer.service.TaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Api(description = "Api related to Tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskDTO> findAll() {return taskService.findAll();}

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public TaskDTO findById(@PathVariable Integer id) { return taskService.findById(id); }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO task){
        return taskService.create(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TaskDTO update(@PathVariable Integer id, @RequestBody TaskDTO dto){
        return taskService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        taskService.delete(id);
    }

}
