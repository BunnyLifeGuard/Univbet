package com.univbet.Entities;

import com.univbet.Enums.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = "findLogin", query = "select u  from UserEntity u where u.username = :username and u.password = :password")
})
public class UserEntity {
    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String username;

    @NotNull
    private Role role;

    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
