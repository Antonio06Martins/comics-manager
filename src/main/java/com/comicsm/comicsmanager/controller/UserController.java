package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.entities.User;
import com.comicsm.comicsmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAll() {
        return userService.listAll();
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        User userSave = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }
}
