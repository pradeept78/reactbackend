package com.demo.reactbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordBcrypt {
    @Bean
    public static boolean encodeEncryptUserPassword(String pass,String dbPass)
    {
        String password = "Hello Password String";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPasswordEncoded = passwordEncoder.encode(password);
        System.out.println("encoded password = "+ testPasswordEncoded);
        boolean matches=passwordEncoder.matches(pass,dbPass);
        return matches;

    }
    @Bean
    public static String encodeEncryptUserPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPasswordEncoded = passwordEncoder.encode(password);
        return testPasswordEncoded;

    }
}
