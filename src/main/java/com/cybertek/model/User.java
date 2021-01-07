package com.cybertek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity<Long>{

    private String firstName;
    private String lastName;

    private LocalDate birthDate;
    // no need to columnDef as a DATE in this

    private String phoneNumber;
    private String userName;
    private String email;
    private String password;


    private String address;



}
