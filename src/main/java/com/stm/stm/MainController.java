package com.stm.stm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private UserService userService;
    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
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
    @GetMapping("users/findById")
    public Optional<User> getUserByEmail(@RequestParam("userId") int userId){
        return userService.getUserByUserId(userId);
    }
}
