package com.atfcm.airportlogistics.controller;


import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    UserSendService userSendService;

    @Autowired
    UserRicipeService userRicipeService;


    @GetMapping("/orders")
    public  String getALLOrders(Map<String,Object> map){
        List<OrderForm> orderForms = new ArrayList<>();

        List<UserSend> sendList = userSendService.selectAllOrders();
        List<UserRecipe> recipeList = userRicipeService.selectAllRecipe();
        System.out.println("发送人信息"+sendList);
        System.out.println("收件人"+recipeList);
        for (UserSend userSend:sendList) {
            OrderForm orderForm = new OrderForm();

            orderForm.setId(userSend.getId());
            orderForm.setOderNumber(userSend.getOderNumber());
            orderForm.setSendername(userSend.getSendername());
            orderForm.setPhoneNumber(userSend.getPhoneNumber());
            orderForm.setProvince(userSend.getProvince());
            orderForm.setCity(userSend.getCity());
            orderForm.setArea(userSend.getArea());
            orderForm.setUserId(userSend.getUserId());
            orderForm.setType(userSend.getType());
            orderForms.add(orderForm);
        }
        int index = 0;
        for (UserRecipe userRecipe:recipeList){
            OrderForm orderForm = orderForms.get(index);
            orderForm.setRecipename(userRecipe.getRecipename());
            orderForm.setRecipePhoneNumber(userRecipe.getRecipePhoneNumber());
            orderForm.setProvinceRecipe(userRecipe.getProvinceRecipe());
            orderForm.setCityRecipe(userRecipe.getCityRecipe());
            orderForm.setAreaRecipe(userRecipe.getAreaRecipe());
            index++;

        }

        map.put("orderForms", orderForms);
        System.out.println(orderForms);

        return "/admin/orders";
    }


    @GetMapping("/order")
    public  String orderAdd(){
        return "/admin/order-add";
    }

    @GetMapping("/test")
    public  String test(){
        return "/admin/test";
    }


}
