package com.emmanuel.todoapi;

import org.springframework.stereotype.Service;

@Service //this allows Spring to manage this class
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("emmanuel");
        boolean isValidPassword = password.equals("password");
        return isValidUsername && isValidPassword;
    }
}
