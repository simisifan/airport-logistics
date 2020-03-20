package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements com.atfcm.airportlogistics.service.UserService {

    @Autowired
    UserMapper userMapper;



    /**
     * 注册功能
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean regist(User user) {
        //1.判断用户名是否存在
        Boolean exist = userMapper.select(user).isEmpty() ? false: true;

        if(exist) {
            //2.存在失败
            return false;
        }else {
            //3.不存在插入
            userMapper.insertSelective(user);
        }

        return true;
    }
}
