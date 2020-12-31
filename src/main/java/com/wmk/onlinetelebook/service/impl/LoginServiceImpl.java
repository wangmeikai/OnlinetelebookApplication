package com.wmk.onlinetelebook.service.impl;

import com.wmk.onlinetelebook.mapper.UserMapper;
import com.wmk.onlinetelebook.pojo.User;
import com.wmk.onlinetelebook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private UserMapper userMapper;

    public boolean loginIn(String userName, String pwd){
        User user = userMapper.selectByUserName(userName);
        return user != null && user.getPassWord().equals(pwd);
    }

    public boolean addUser(String userName,String pwd){
        User user = userMapper.selectByUserName(userName);
        if (user!=null){
            return false;
        }else {
            int i = userMapper.insertUser(userName, pwd);
            return i != 0;
        }
    }



    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
