package com.univbet.DTO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("User")
@SessionScoped
public class User implements Serializable {
    private String firstnameUser;
    private String username;
    private String password;
    private String role;

    public User() {}

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private void login() {}

    private void signIn() {}
}
