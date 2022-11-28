package com.demo.reactbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    //@ManyToOne(fetch = FetchType.EAGER,optional=false )
    //@JoinColumn(name="location_id")
    //private Location location;
}
