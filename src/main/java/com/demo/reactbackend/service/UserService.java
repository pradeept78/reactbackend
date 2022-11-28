package com.demo.reactbackend.service;

import com.demo.reactbackend.dto.UserDto;
import com.demo.reactbackend.entity.Users;
import com.demo.reactbackend.exception.ResourceNotFoundException;
import com.demo.reactbackend.repository.UserRepository;

import com.demo.reactbackend.security.Password;
import com.demo.reactbackend.security.PasswordBcrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.demo.reactbackend.security.Password.checkPassword;
import static com.demo.reactbackend.security.Password.hashPassword;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserService  {

    @Autowired
    UserRepository userRepository;

    PasswordBcrypt passwordBcrypt;

    public List<UserDto> login(UserDto user){

        UserDto userDto = new UserDto();
        Long count = 0l;
        count = userRepository.findEmailCount(user.getEmail().toString());
        Users data = userRepository.findEmail(user.getEmail().toString());

        userRepository.findAll().stream().map(this::getUserDto).collect(Collectors.toList());

        boolean test = passwordBcrypt.encodeEncryptUserPassword(user.getPassword(),data.getPassword());


        if(count>0){
            if(test==true){
               return userRepository.findAll().stream().map(this::getUserDto).collect(Collectors.toList());
            }
            else
                throw new IllegalStateException("wrong user id/password ");
        }
        else{
            throw new IllegalStateException("no record found");
        }

    }

    public UserDto getUserDto(Users user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        //userDto.setPlace(user.getLocation().getPlace());
        return userDto;

    }



//    public void register(Users user) {
//       // User data = new User();
//        Long count=0l;
//        try{
//            count = userRepository.findEmailCount(user.getEmail().toString());
//        }
//        catch (Exception e){
//            throw new ResourceNotFoundException("wrong query");
//        }
//        if(count>0){
//            throw new ResourceNotFoundException("user already present try login");
//
//        }
//        if(count>=0){
//            userRepository.save(user);
//
//        }
//    }



    public UserDto register(UserDto user) {
        Users saveData = new Users();

        Long count = 0l;
        try {
            count = userRepository.findEmailCount(user.getEmail().toString());
        } catch (Exception e) {
            throw new ResourceNotFoundException("wrong query");
        }
        if (count > 0) {
            throw new ResourceNotFoundException("user already present try login");

        }
        if (count >= 0) {
            saveData.setPassword(passwordBcrypt.encodeEncryptUserPassword(user.getPassword()));
            saveData.setEmail(user.getEmail());
            saveData.setFirstName(user.getFirstName());
            saveData.setLastName(user.getLastName());
            userRepository.save(saveData);
        }
        return null;
    }
}
