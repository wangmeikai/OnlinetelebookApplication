package com.wmk.onlinetelebook.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    public static Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put("wmk","123456");
        map.put("admin","123456");
    }
    public boolean loginIn(String userName,String pwd){
        String passwd = map.get(userName);
        return passwd != null && passwd.equals(pwd);
    }

    public boolean addUser(String userName,String pwd){
        if (map.get(userName)!=null){
            return false;
        }else {
            map.put(userName,pwd);
            return true;
        }
    }

}
