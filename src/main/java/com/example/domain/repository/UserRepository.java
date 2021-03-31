package com.example.domain.repository;

import com.example.domain.models.user.Address;
import com.example.domain.models.user.Roles;
import com.example.domain.models.user.User;
import com.example.domain.models.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private final List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        innit();
    }

    private void innit(){
        userList.add(new User(UUID.fromString("2524ba8d-de3c-4a2f-a290-7ffc2713e250"),new Address("adminStreet", "15", "1000", "Brussel"),
                new UserInfo("Admin", "Admin", "admin@eurder.be", "023658974"), List.of(Roles.USER,Roles.ADMIN)));

        userList.add(new User(UUID.fromString("5188190a-e994-40bb-a637-0140851f9728"),new Address("Oude ieperseweg", "18", "8501", "Heule"),
                new UserInfo("Miguel", "Maieur", "miguel@hotmail.be", "0493125698"), List.of(Roles.USER)));
    }

    public Collection<User> getAllUsers(){
        return Collections.unmodifiableCollection(userList);
    }

    public User addUser(User user){
        userList.add(user);
        logger.info("user was added to the database with id :" + user.getId());
        return user;
    }
}
