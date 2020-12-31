package com.wmk.onlinetelebook.mapper;

import com.wmk.onlinetelebook.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectByUserName(String userName);

    int insertUser(String userName, String passWord);
}
