package com.atfcm.airportlogistics.service;


import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserSend;

import java.util.List;

public interface UserSendService {
    public  Boolean insertUserSend(UserSend userSend);
    /*这个名字应该是   selectALLSend*/
    public List<UserSend> selectAllOrders();

    public  List<OrderForm>  selectAllSendRecip();

    public int updateStart(String oder);


}
