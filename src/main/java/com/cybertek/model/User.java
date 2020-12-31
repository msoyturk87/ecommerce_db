package com.cybertek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
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

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    private String phoneNumber;
    private String userName;
    private String password;

    @Column(columnDefinition = "TEXT")
    private String address;



}
