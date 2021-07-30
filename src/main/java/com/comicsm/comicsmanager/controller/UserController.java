package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.dto.user.UserRequestDTO;
import com.comicsm.comicsmanager.dto.user.UserResponseDTO;
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
import java.util.stream.Collectors;

@Api(tags = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "List All", nickname = "listAll")
    @GetMapping
    public List<UserResponseDTO> listAll() {
        return userService.listAll()
                .stream().map(user -> UserResponseDTO.convertToUserDTO(user))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Save", nickname = "saveUser")
    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO userDto) {
        User userSave = userService.save(userDto.convertToEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.convertToUserDTO(userSave));
    }

    @ApiOperation(value = "Delete", nickname = "deleteUser")
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long code) {
        userService.delete(code);
    }
}
