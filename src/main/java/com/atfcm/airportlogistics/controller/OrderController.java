package com.atfcm.airportlogistics.controller;


import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.service.AdminService;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Update;
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

    @Autowired
    AdminService adminService;


    /*查看所有订单*/
    @RequestMapping("/orders")
    public  String getALLOrders(Map<String,Object> map,@RequestParam(value = "pn",defaultValue = "0") Integer pn){
        //紧跟他的查询就是分页查询
       PageHelper.startPage(pn, 10);
      List<OrderForm> orderForms = userSendService.selectAllSendRecip();
        PageInfo<OrderForm> info = new PageInfo<>(orderForms,2);

        map.put("orderForms", orderForms);
        map.put("info",info);
        System.out.println(orderForms);

        return "/admin/orders";
    }

/*
    页面转发
 */
    @RequestMapping("/order")
    public  String orderAdd(String orderNumber,Map<String,Object> map){
        OrderForm orderForm = adminService.selectByOderNumber(orderNumber);
        map.put("orderForm",orderForm);
        return "/admin/order-add";
    }


    /*修改  start 字段*/
    @PutMapping("/od/{orderNumber}")
    public  String updateOrderForm(@PathVariable("orderNumber") String oderNumber){
        System.out.println(oderNumber);
        userSendService.updateStart(oderNumber);
        return "redirect:/orders";
    }

    /**
     * 删除订单
     * @param oderNumber
     * @return
     */
    @DeleteMapping("/od/{oderNumber}")
    public String delete(@PathVariable String oderNumber){
        adminService.deleteOrder(oderNumber);
        return "redirect:/orders";

    }


    @PutMapping("/order")
    public String Update(OrderForm orderForm){
        System.out.println(orderForm);
        return "success";
    }








}
