package com.example.service;

import com.example.domain.models.user.Address;
import com.example.domain.models.user.Roles;
import com.example.domain.models.user.User;
import com.example.domain.models.user.UserInfo;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.exceptions.UserAlreadyExitsException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserById() {
        //given
        UserService service = new UserService(new UserRepository());
        //when
        User user = service.getUserById(UUID.fromString("5188190a-e994-40bb-a637-0140851f9728"));
        //then
        assertEquals("miguel@hotmail.be",user.getUserInfo().getEmail());
    }

    @Test
    void getUserIsInRoleUser(){
        //given
        UserService service = new UserService(new UserRepository());
        //when
        User user = service.getUserById(UUID.fromString("5188190a-e994-40bb-a637-0140851f9728"));
        //then
        assertTrue(service.isUserInRoleUser(user.getId()));
    }

    @Test
    void getUserIsInRoleAdmin(){
        //given
        UserService service = new UserService(new UserRepository());
        //when
        User user = service.getUserById(UUID.fromString("2524ba8d-de3c-4a2f-a290-7ffc2713e250"));
        //then
        assertTrue(service.isUserInRoleAdmin(user.getId()));
    }

    @Test
    void addUserTwiceThrowsException(){
        //given
        UserService service = new UserService(new UserRepository());
        //when
        service.addUser(new User(new Address("street","18","8501","Heule"),
                new UserInfo("firstname","lastename","miguel.maieur@hotmail.com","056986532"), List.of(Roles.USER)));
        Exception exception = assertThrows(UserAlreadyExitsException.class,() -> service.addUser(new User(new Address("street","18","8501","Heule"),
                new UserInfo("firstname","lastename","miguel.maieur@hotmail.com","056986532"), List.of(Roles.USER))));
        //then
        assertEquals("This email is already registered",exception.getMessage());
    }
}