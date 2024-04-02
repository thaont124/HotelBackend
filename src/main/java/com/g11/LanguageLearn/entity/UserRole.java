package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Integer idUserRole;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "idRole")
    private Role role;
}
