package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    private String username;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String cccd;

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
