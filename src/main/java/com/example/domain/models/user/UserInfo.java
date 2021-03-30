package com.example.domain.models.user;

import com.example.infrastructure.exceptions.UserFieldNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfo {
    private static final Logger logger = LoggerFactory.getLogger(UserInfo.class);

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;

    public UserInfo(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = validator(firstName,"firstname");
        this.lastName = validator(lastName,"lastname");
        this.email = validator(email,"email");
        this.phoneNumber = validator(phoneNumber,"phonenumber");
    }

    private String validator(String value,String field){
        if(value == null || value.isBlank()){
            logger.warn("The field " + field + " was not valid.");
            throw new UserFieldNotValidException(field + " was not valid.");
        }
        return value;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
