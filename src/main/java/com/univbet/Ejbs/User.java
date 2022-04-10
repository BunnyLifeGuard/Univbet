package com.univbet.Ejbs;

import com.univbet.DTO.UserDto;

import java.io.IOException;

public interface User {
    void login(UserDto user) throws IOException;
    void signIn(UserDto user);
}
