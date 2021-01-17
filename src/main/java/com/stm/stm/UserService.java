package com.stm.stm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private TaskService taskService;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserByUserId(int userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findById(userId);
        } else {
            return null;
        }
    }
    public User updateStatus(int userId, boolean newStatus){
        User user =null;
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User userToUpdate= userOptional.get();
            userToUpdate.setStatus(newStatus);
            user = userRepository.save(userToUpdate);
        }
        return user;
    }
    public boolean deleteUserById(int userId){
        boolean result = false;
        if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            result = true;
        }
        return result;
    }
    public boolean createTaskByUser(int userId, Task task){

        Optional<User> userTask = userRepository.findById(userId);
        taskService.addTask(task);
        return userTask.get().addTask(task);

    }
    }
