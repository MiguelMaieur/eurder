package com.example.domain.models.user;

import com.example.infrastructure.exceptions.UserFieldNotValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Address {
    private static final Logger  logger = LoggerFactory.getLogger(Address.class);
    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String street, String streetNumber, String postalCode, String city) {
        this.street = validator(street,"street");
        this.streetNumber = validator(streetNumber,"streetNumber");
        this.postalCode = validator(postalCode,"postalCode");
        this.city = validator(city,"city");
    }

    private String validator(String value,String field){
        if(value == null || value.isBlank()){
            logger.warn("The field " + field + " was not valid.");
            throw new UserFieldNotValid(field + " was not a valid.");
        }
        return value;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
