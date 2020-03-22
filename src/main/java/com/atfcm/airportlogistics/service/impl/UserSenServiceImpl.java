package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.mbg.mapper.UserSendMapper;
import com.atfcm.airportlogistics.service.UserSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSenServiceImpl implements UserSendService {

    @Autowired
    UserSendMapper userSendMapper;

    @Override
    public Boolean insertUserSend(UserSend userSend) {
        //插入一条寄件人信息
        final int i = userSendMapper.insertSelective(userSend);
        if(i>0){
            return  true;
        }else {
            return false;
        }

    }

    @Override
    public List<UserSend> selectAllOrders() {
        return   userSendMapper.selectAll();
    }
}
