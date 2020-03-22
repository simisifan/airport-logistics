package com.atfcm.airportlogistics.service;


import com.atfcm.airportlogistics.mbg.bean.UserSend;

import java.util.List;

public interface UserSendService {
    public  Boolean insertUserSend(UserSend userSend);
    public List<UserSend> selectAllOrders();

}
