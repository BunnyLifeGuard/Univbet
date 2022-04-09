package com.univbet.Entities;

import com.univbet.Enums.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserEntity {
    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String lastname;

    @NotNull
    private String firstname;

    @NotNull
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Role getRole() {
        return role;
    }
}
