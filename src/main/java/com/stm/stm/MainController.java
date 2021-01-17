package com.stm.stm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private UserService userService;
    private TaskService taskService;
    @Autowired
    public MainController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping("/users/register")
    public User registerUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        User user = new User(name, lastName, email, password);  // definition and init of User class object
        return userService.addUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/findById")
    public Optional<User> getUserByEmail(@RequestParam("userId") int userId){
        return userService.getUserByUserId(userId);
    }
    @PutMapping("/users/changeStatus")
    public User updateStatus(@RequestParam("userId") int userId, @RequestParam("newStatus") Boolean newStatus){
        return userService.updateStatus(userId,newStatus);
    }
    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUserById(@PathVariable("userId")int userId){
        return userService.deleteUserById(userId);
    }
    @PostMapping("/users/tasks/add")
    public boolean addTaskByUserId(@PathVariable("userId")int userId, @RequestParam("title")String title, @RequestParam("description")String description){
        Task newTask = new Task(title,description);
        return userService.createTaskByUser(userId,newTask);
    }
    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
