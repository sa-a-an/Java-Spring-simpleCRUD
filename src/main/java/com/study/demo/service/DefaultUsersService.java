package com.study.demo.service;

import com.study.demo.dto.UsersDto;
import com.study.demo.entity.Users;
import com.study.demo.exception.ValidationException;
import com.study.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@Log
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)){
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException{
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUsers(usersDto));
        return usersConverter.fromUsersToUsersDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId){
        usersRepository.deleteById(userId);
    }


    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUsersToUsersDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll(){
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUsersToUsersDto)
                .collect(Collectors.toList());
    }



}
