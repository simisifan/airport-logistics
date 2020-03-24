package com.atfcm.airportlogistics.mbg.mapper;

import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
public interface AdminMapper extends Mapper<Admin> {
    @Delete("DELETE ts,tr FROM table_user_send  \n" +
            "AS ts LEFT JOIN table_user_recipe AS tr \n" +
            "ON ts.`oder_number`=tr.`oder_number` \n" +
            "WHERE ts.`oder_number`=#{oderNumber}")
    public  int deleteSendRecip(String oderNumber);


    public OrderForm selectByOderNumber(String oderNumber);
}