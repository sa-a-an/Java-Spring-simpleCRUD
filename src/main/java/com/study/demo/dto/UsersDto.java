package com.study.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {

    private Integer id;
    private String login;
    private String password;
    private String email;

}
