package com.example.domain.models.user;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final Address address;
    private final UserInfo userInfo;
    private final List<Roles> rolesList;

    public User(Address address, UserInfo userInfo, List<Roles> rolesList) {
        this.address = address;
        this.userInfo = userInfo;
        this.rolesList = rolesList;
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

    public Collection<Roles> getRoles(){
        return rolesList;
    }
}
