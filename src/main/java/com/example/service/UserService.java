package com.example.service;

import com.example.domain.models.user.User;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.exceptions.UserAlreadyExitsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        if(!checkIfUserIsDuplicate(user)){
            logger.warn("A user tried to register a email that is already in the database : " + user.getUserInfo().getEmail());
            throw new UserAlreadyExitsException("This email is already registered");
        }
        return userRepository.addUser(user);
    }

    private boolean checkIfUserIsDuplicate(User user) {
        return userRepository.getAllUsers().stream().filter(c -> c.getUserInfo().getEmail().equals(user.getUserInfo().getEmail())).collect(Collectors.toList()).isEmpty();
    }


}
