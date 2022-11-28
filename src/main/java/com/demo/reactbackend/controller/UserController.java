package com.demo.reactbackend.controller;

import com.demo.reactbackend.dto.GenericResponseDto;
import com.demo.reactbackend.dto.GenericResponseDto.GenericResponseDtoBuilder;
import com.demo.reactbackend.dto.UserDto;
import com.demo.reactbackend.entity.Users;
import com.demo.reactbackend.exception.ResourceNotFoundException;
import com.demo.reactbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public GenericResponseDto<UserDto> login(@RequestBody UserDto user, HttpServletRequest req){

        List<UserDto> response = userService.login(user);

        return new GenericResponseDtoBuilder("Log-in Success", req,response).statusCode(200).build();
    }

//    @PostMapping("/register")
//    public String register(@RequestBody Users user){
//        if(user.getEmail().isEmpty() || user.getPassword().isEmpty())
//            throw new ResourceNotFoundException("data is empty");
//        userService.register(user);
//        return "Registered successfully";
//
//    }

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto user) {

        return userService.register(user);

    }


}
