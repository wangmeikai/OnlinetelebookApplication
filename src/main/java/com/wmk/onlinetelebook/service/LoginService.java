package com.wmk.onlinetelebook.service;

public interface LoginService {
    boolean loginIn(String userName,String pwd);

    boolean addUser(String userName,String pwd);

}
