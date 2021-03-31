package com.example.api.controllers;

import com.example.api.dto.User.CreateUserDTO;
import com.example.api.dto.User.UserDTO;
import com.example.api.mappers.UserMapper;
import com.example.infrastructure.exceptions.Unauthorized;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(@RequestHeader("Authorization") UUID adminId){
        if(!userService.isUserInRoleAdmin(adminId)){
            logger.warn("Someone tried to view all members without an admin id; id used : " + adminId);
            throw new Unauthorized("You are not authorized to see this list.");
        }
        return userMapper.userListToUserDTOList(userService.getAllUsers());
    }

    @GetMapping(path = "/{userId}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable UUID userId,@RequestHeader("Authorization") UUID adminId){
        if(!userService.isUserInRoleAdmin(adminId)){
            logger.warn("Someone tried to view a members without an admin id. id used : " + adminId + " ,id asked " + userId);
            throw new Unauthorized("You are not authorized to see this info.");
        }
        return userMapper.UserToUserDTO(userService.getUserById(userId));
    }
}
