package com.alyater.tax_api.model;

public class AuthenticatedUser extends User{
    private String token;

    public AuthenticatedUser(String token) {
        this.token = token;
    }

    public AuthenticatedUser(String username, String password, String taxnumber, String token) {
        super(username, password, taxnumber);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    

}
