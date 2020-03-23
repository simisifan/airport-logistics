package com.atfcm.airportlogistics.controller;


import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    /*查看所有订单*/
    @RequestMapping("/orders")
    public  String getALLOrders(Map<String,Object> map){
      List<OrderForm> orderForms = userSendService.selectAllSendRecip();
        map.put("orderForms", orderForms);
        System.out.println(orderForms);

        return "/admin/orders";
    }

/*
   手动添加订单
 */
    @RequestMapping("/order")
    public  String orderAdd(){
        return "/admin/order-add";
    }


    @PutMapping("/od/{orderNumber}")
    public  String updateOrderForm(@PathVariable("orderNumber") String oderNumber){
        System.out.println(oderNumber);
        userSendService.updateStart(oderNumber);
        return "success";
    }

    @DeleteMapping("/od")
    public String delete( String id){
        System.out.println(id);
        System.out.println(id);
        return "success";

    }








}
