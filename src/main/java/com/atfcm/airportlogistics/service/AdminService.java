package com.atfcm.airportlogistics.service;

import com.atfcm.airportlogistics.common.OrderForm;

public interface AdminService {

    public  int deleteOrder(String orderNumber);

    public OrderForm selectByOderNumber(String oderNumber);
}
