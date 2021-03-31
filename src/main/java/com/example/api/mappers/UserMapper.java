package com.example.api.mappers;

import com.example.api.dto.User.CreateUserDTO;
import com.example.api.dto.User.UserDTO;
import com.example.api.dto.item.ItemDTO;
import com.example.domain.models.user.Address;
import com.example.domain.models.user.Roles;
import com.example.domain.models.user.User;
import com.example.domain.models.user.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User CreateUserDTOTOUser(CreateUserDTO createUserDTO){
        return new User(new Address(createUserDTO.getStreet(), createUserDTO.getStreetNumber(), createUserDTO.getPostalCode(), createUserDTO.getCity()),
                new UserInfo(createUserDTO.getFirstName(), createUserDTO.getLastName(), createUserDTO.getEmail(), createUserDTO.getPhoneNumber()), List.of(Roles.USER));
    }

    public UserDTO UserToUserDTO(User user){
        return new UserDTO().setCity(user.getAddress().getCity())
                .setEmail(user.getUserInfo().getEmail())
                .setFirstName(user.getUserInfo().getFirstName())
                .setLastName(user.getUserInfo().getLastName())
                .setId(user.getId())
                .setPhoneNumber(user.getUserInfo().getPhoneNumber())
                .setPostalCode(user.getAddress().getPostalCode())
                .setStreet(user.getAddress().getStreet())
                .setStreetNumber(user.getAddress().getStreetNumber());
    }

    public List<UserDTO> userListToUserDTOList(Collection<User> users){
        return users.stream().map(this::UserToUserDTO).collect(Collectors.toList());
    }
}
