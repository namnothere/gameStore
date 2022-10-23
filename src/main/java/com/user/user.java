package com.user;

import java.io.Serializable;
import com.store.MongoUtils;

public class user {
    private String name;
    private String username;
    private String email;
    private String password;

    public user() {
        name = "";
        email = "";
        username = "";
        password = "";
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return MongoUtils.isValidUser(username, password);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword == password) {
            password = newPassword;
            return true;
        }
        return false;
    }
}
