package com.atfcm.airportlogistics.service.impl;

import cn.hutool.core.date.DateUtil;
import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.mbg.bean.FlyInfo;
import com.atfcm.airportlogistics.mbg.mapper.AdminMapper;
import com.atfcm.airportlogistics.mbg.mapper.UserSendMapper;
import com.atfcm.airportlogistics.mbg.mapper.FlyInfoMapper;
import com.atfcm.airportlogistics.service.UserSendService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSenServiceImpl implements UserSendService {

    @Autowired
            UserSendMapper userSendMapper;

    @Autowired
    FlyInfoMapper flyInfoMapper;

    @Autowired
    AdminMapper adminMapper;

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

    @Override
    public List<OrderForm> selectAllSendRecip() {
        return  userSendMapper.getAllOrderForm();
    }

    @Override
    @Transactional
    public int updateStartAndInserttFlyinfo(String oder, FlyInfo flyInfo) {
        OrderForm orderForm = adminMapper.selectByOderNumber(oder);

        flyInfo.setOderNumber(oder);
        //开始位置
        flyInfo.setLocationBegin(orderForm.getProvince());
        //结束位置
        flyInfo.setLocationEnd(orderForm.getProvinceRecipe());
        //现在的位置
        flyInfo.setLocationNow(orderForm.getProvince()+orderForm.getCity()+orderForm.getArea());
        //货物的状态
        flyInfo.setStatus("快递员正在揽件");
        //开始的时间
        flyInfo.setTimeBegin(DateUtil.date(System.currentTimeMillis()));
        //用户id
        flyInfo.setUserId(orderForm.getUserId());
        //执行更新
        flyInfoMapper.insertSelective(flyInfo);

        return  userSendMapper.updateStart(oder);
    }

    /*更新预约表*/
    @Override
    @Transactional
    public void updateOrderForm(@Param("orderForm") OrderForm orderForm) {
          userSendMapper.updateOrderForm(orderForm);

    }
}
