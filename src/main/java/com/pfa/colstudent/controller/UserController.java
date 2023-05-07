package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Ecole;
import com.pfa.colstudent.model.User;
import com.pfa.colstudent.service.EcoleService;
import com.pfa.colstudent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/auth/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getEcoleById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/post")
    public User postUser(@RequestBody User user){
      return  userService.saveUser( user );
    }
}
