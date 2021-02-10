package com.study.demo.service;

import com.study.demo.dto.UsersDto;
import com.study.demo.entity.Users;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public Users fromUserDtoToUsers(UsersDto usersDto){
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setLogin(usersDto.getLogin());
        return users;
    }


    public UsersDto fromUsersToUsersDto(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .password(users.getPassword())
                .build();
    }
}
