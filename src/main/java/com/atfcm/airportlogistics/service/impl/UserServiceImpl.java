package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.mbg.mapper.UserMapper;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        Boolean exist = userMapper.selectByUsername(user.getUsername()) != null;

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
        List<User> users = userMapper.select(user);
        Boolean login= !users.isEmpty();
        //2."查询封装的主键"
        Integer id = users.get(0).getId();
        if(login){
           //2.用户名密码正确  session加入isLogin字段,设置true
           request.getSession().setAttribute("isLogin", id);
           return true;
       }else{
           return  false;
       }
    }



    @Override
    @Transactional
    public Boolean sendForm(UserSendService userSendService, UserRicipeService userRicipeService, UserSend u4, UserRecipe userRecipe) {
       Boolean bothInsert= userSendService.insertUserSend(u4) && userRicipeService.inserUserRecipe(userRecipe);
       if (bothInsert){
           return  true;
       }else {
           return  false;
       }

    }



}
