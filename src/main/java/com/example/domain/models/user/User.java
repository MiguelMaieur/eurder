package com.example.domain.models.user;

import java.util.UUID;

public class User {
    private final UUID id;
    private final Address address;
    private final UserInfo userInfo;

    public User(Address address, UserInfo userInfo) {
        this.address = address;
        this.userInfo = userInfo;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
