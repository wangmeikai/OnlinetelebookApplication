package com.wmk.onlinetelebook.service.impl;

import com.wmk.onlinetelebook.mapper.DateTestMapper;
import com.wmk.onlinetelebook.pojo.DateTest;
import com.wmk.onlinetelebook.service.DateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateTestServiceImpl implements DateTestService {

    private DateTestMapper dateTestMapper;

    @Autowired
    public void setDateTestMapper(DateTestMapper dateTestMapper) {
        this.dateTestMapper = dateTestMapper;
    }

    @Override
    public int insertTime(DateTest dateTest) {
        return dateTestMapper.insertTime(dateTest);
    }
}
