package com.wmk.onlinetelebook.mapper;

import com.wmk.onlinetelebook.pojo.DateTest;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTestMapper {

    int insertTime(DateTest dateTest);
}
