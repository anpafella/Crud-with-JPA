package com.anpa.crud.controller;

import com.anpa.crud.model.User;
import com.anpa.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ArrayList<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        System.out.println("nuevo user: "+ user.toString());
        return userService.createUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }

    @DeleteMapping(path = "/fulldelete")
    public String deleteUserById(){
        return userService.deleteAll();
    }
}
