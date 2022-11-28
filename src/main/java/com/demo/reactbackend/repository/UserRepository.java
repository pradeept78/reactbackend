package com.demo.reactbackend.repository;

import com.demo.reactbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "select count(email) from Users u where email=?1",nativeQuery = true)
    public Long findEmailCount(String email);

    @Query(value = "select * from Users u where email=?1",nativeQuery = true)
    public Users findEmail(String email);

    Users findByEmail(String username);
}
