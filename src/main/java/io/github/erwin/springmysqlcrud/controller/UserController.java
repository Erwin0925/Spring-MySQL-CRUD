package io.github.erwin.springmysqlcrud.controller;

import io.github.erwin.springmysqlcrud.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.erwin.springmysqlcrud.service.UserService;
import io.github.erwin.springmysqlcrud.entity.User;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User added successfully";
    }


    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/by-id")
    public User getUser(@RequestParam int id){
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/UpdateName/{id}")
    public ResponseEntity<User> UpdateName(@PathVariable int id, @RequestBody UserDto user){
        User updatedUser = userService.updateUserName(id, user);
        return ResponseEntity.ok(updatedUser);
    }

}
