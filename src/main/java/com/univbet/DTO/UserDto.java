package com.univbet.DTO;

import com.univbet.Ejbs.User;
import com.univbet.Entities.UserEntity;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named("User")
@SessionScoped
public class UserDto implements Serializable {

    @EJB
    private User UserBean;

    private String firstnameUser;
    private String username;
    private String password;
    private String role;

    public UserDto() {}

    public UserDto(UserEntity userEntity) {
        this.firstnameUser = userEntity.getFirstname();
        this.username = userEntity.getUsername();
        this.role = userEntity.getRole().toString();
        this.password = userEntity.getPassword();
    }

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

    public void login(UserDto user) throws IOException {
        this.UserBean.login(this);
    }

    public void signIn(UserDto user) {
        this.UserBean.signIn(this);
    }
}
