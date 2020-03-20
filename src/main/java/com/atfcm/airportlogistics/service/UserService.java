package com.atfcm.airportlogistics.service;


import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    /**
     * 注册
     */
    public boolean regist(User user);
}
