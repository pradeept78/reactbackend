package com.demo.reactbackend.dto;

import com.demo.reactbackend.entity.Location;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
public class UserDto {

    private long id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String place;

    private Location location;
}
