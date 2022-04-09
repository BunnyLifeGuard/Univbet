package com.univbet.DTO;

import javax.inject.Named;

@Named("User")
public class User {
    private String lastnameUser;
    private String firstnameUser;
    private String username;
    private String role;

    public User() {}

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastNameUser) {
        this.lastnameUser = lastNameUser;
    }

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstnameUser = firstNameUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private void login() {}

}
