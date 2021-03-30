package com.example.api.controllers;

import com.example.api.dto.User.CreateUserDTO;
import com.example.api.dto.User.UserDTO;
import com.example.api.mappers.UserMapper;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody CreateUserDTO createUserDTO){
        return userMapper.UserToUserDTO(userService.addUser(userMapper.CreateUserDTOTOUser(createUserDTO)));
    }
}
