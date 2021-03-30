package com.example.api.dto.User;

public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    public CreateUserDTO() {
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

    public CreateUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateUserDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CreateUserDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    public CreateUserDTO setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public CreateUserDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public CreateUserDTO setCity(String city) {
        this.city = city;
        return this;
    }
}
