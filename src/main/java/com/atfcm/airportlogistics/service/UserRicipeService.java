package com.atfcm.airportlogistics.service;

import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;

import java.util.List;

public interface UserRicipeService {

    public Boolean inserUserRecipe(UserRecipe userRecipe);
    public List<UserRecipe> selectAllRecipe();
}
