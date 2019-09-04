package com.cryptal.ark.arkcreditservice.user.request;

import java.io.Serializable;

public class RegisterUserRequest implements Serializable {

    private String username;

    private String authorizeCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorizeCode() {
        return authorizeCode;
    }

    public void setAuthorizeCode(String authorizeCode) {
        this.authorizeCode = authorizeCode;
    }
}
