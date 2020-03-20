package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements com.atfcm.airportlogistics.service.UserService {

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
        Boolean exist = userMapper.selectByUsername(user.getUsername())==null ? false: true;

        if(exist) {
            //2.存在失败
            return false;
        }else {
            //3.不存在插入
            userMapper.insertSelective(user);
        }

        return true;
    }



    /**
     * 登陆功能
     * */
    @Override
    public Boolean login(User user, HttpServletRequest request) {
        //1.检查用户名和密码是否正确
        Boolean login= userMapper.select(user).isEmpty() ? false: true;
       if(login){
           //2.用户名密码正确  session加入isLogin字段,设置true
           request.getSession().setAttribute("isLogin", "plain_user");
           return true;
       }else{
           return  false;
       }
    }

}
