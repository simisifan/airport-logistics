package com.atfcm.airportlogistics.service;


import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 注册
     */
    public boolean regist(User user);
    /*
    * 登陆
    * */
    public Boolean login(User user, HttpServletRequest request);

    public Boolean  sendForm(UserSendService userSendService, UserRicipeService userRicipeService, UserSend u4, UserRecipe userRecipe);
}
