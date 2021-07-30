package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.entities.User;
import com.comicsm.comicsmanager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "List All", nickname = "listAll")
    @GetMapping
    public List<User> listAll() {
        return userService.listAll();
    }

    @ApiOperation(value = "Save", nickname = "saveUser")
    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        User userSave = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }

    @ApiOperation(value = "Delete", nickname = "delete")
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long code) {
        userService.delete(code);
    }
}
