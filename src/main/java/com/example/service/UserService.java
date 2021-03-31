package com.example.service;

import com.example.domain.models.user.Roles;
import com.example.domain.models.user.User;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.exceptions.UserAlreadyExitsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
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
        return userRepository.getAllUsers().stream().filter(c -> c.getUserInfo().getEmail().toLowerCase().equals(user.getUserInfo().getEmail().toLowerCase())).collect(Collectors.toList()).isEmpty();
    }

    public boolean isUserInRoleAdmin(UUID id){
        return userRepository.getAllUsers().stream().filter(c -> c.getId().equals(id) && c.getRoles().contains(Roles.ADMIN)).count() == 1;
    }

    public boolean isUserInRoleUser(UUID id){
        return userRepository.getAllUsers().stream().filter(c -> c.getId().equals(id) && c.getRoles().contains(Roles.USER)).count() == 1;
    }

    public User getUserById(UUID id){
        return userRepository.getAllUsers().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Collection<User> getAllUsers(){
        return userRepository.getAllUsers().stream().filter(c -> c.getRoles().size() == 1 && c.getRoles().contains(Roles.USER)).collect(Collectors.toList());
    }
}
