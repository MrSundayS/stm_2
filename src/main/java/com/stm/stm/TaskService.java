package com.stm.stm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskByUserId(int taskId) {
        if (taskRepository.existsById(taskId)) {
            return taskRepository.findById(taskId);
        } else {
            return null;
        }
    }
}
