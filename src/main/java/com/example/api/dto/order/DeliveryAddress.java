package com.example.api.dto.order;

public class DeliveryAddress {
    private final String fullName;
    private final String Street;
    private final String postalCode;
    private final String city;

    public DeliveryAddress(String fullName, String street, String postalCode, String city) {
        this.fullName = fullName;
        Street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreet() {
        return Street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
