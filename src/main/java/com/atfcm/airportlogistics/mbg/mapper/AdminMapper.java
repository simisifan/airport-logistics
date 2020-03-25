package com.atfcm.airportlogistics.mbg.mapper;

import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
public interface AdminMapper extends Mapper<Admin> {

    public  int deleteSendRecip(String oder_number);


    public OrderForm selectByOderNumber(String oderNumber);
}