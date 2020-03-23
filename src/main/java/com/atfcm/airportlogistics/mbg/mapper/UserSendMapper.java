package com.atfcm.airportlogistics.mbg.mapper;

import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserSendMapper extends Mapper<UserSend> {

    public List<OrderForm> getAllOrderForm();

    @Update("UPDATE table_user_send  ts SET  ts.`start` =TRUE WHERE  oder_number = #{oderNumber} ")
    public int updateStart(String oderNumber);
}