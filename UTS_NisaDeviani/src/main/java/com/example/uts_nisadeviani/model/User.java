package com.example.uts_nisadeviani.model;

public class User {
    private Integer idUser;
    private String UserName;
    private String UserPassword;

    public User(String userName, String userPassword) {
        UserName = userName;
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return  UserName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
