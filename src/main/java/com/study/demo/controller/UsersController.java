package com.study.demo.controller;

import com.study.demo.dto.UsersDto;
import com.study.demo.exception.ValidationException;
import com.study.demo.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException{
        log.info("Handling save users: " + usersDto);

        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAll(){
        log.info("Handling All users return");

        return usersService.findAll();
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handaling delete user");
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Handaling find by login:" + login);

        return usersService.findByLogin(login);
    }
}
