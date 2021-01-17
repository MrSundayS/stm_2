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
    public Task updateStatus(int taskId, Task.status newStatus){
        Task task =null;
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if(taskOptional.isPresent()){
            Task taskToUpdate= taskOptional.get();
            taskToUpdate.setTaskStatus(newStatus);
            task = taskRepository.save(taskToUpdate);
        }
        return task;
    }
    public boolean deleteTaskById(int taskId){
        boolean result = false;
        if(taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            result = true;
        }
        return result;
    }
}
