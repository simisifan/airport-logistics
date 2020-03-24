package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.mapper.AdminMapper;
import com.atfcm.airportlogistics.service.AdminService;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminMapper adminMapper;


    @Override
    @Transactional
    public int deleteOrder(String orderNumber) {
        return adminMapper.deleteSendRecip(orderNumber);

    }

    @Override
    @Transactional
    public OrderForm selectByOderNumber(String oderNumber) {
        OrderForm orderForm = adminMapper.selectByOderNumber(oderNumber);
        return orderForm;
    }



}
