package com.atfcm.airportlogistics.mbg.mapper;

import com.atfcm.airportlogistics.mbg.bean.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
public interface UserMapper extends Mapper<User> {

    public User  selectByUsername(String username);
}