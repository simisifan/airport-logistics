package com.atfcm.airportlogistics.service.impl;

import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.mapper.UserRecipeMapper;
import com.atfcm.airportlogistics.service.UserRicipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRecipeServiceImp  implements UserRicipeService {
    @Autowired
    UserRecipeMapper userRecipeMapper;
    @Override
    public Boolean inserUserRecipe(UserRecipe userRecipe) {
        int result = userRecipeMapper.insertSelective(userRecipe);
        if(result>0){
            return  true;
        }else {
            return false;
        }
    }
}
