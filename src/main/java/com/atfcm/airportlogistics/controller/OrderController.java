package com.atfcm.airportlogistics.controller;


import com.atfcm.airportlogistics.common.OrderForm;
import com.atfcm.airportlogistics.common.ResultInfo;
import com.atfcm.airportlogistics.mbg.bean.FlyInfo;
import com.atfcm.airportlogistics.service.AdminService;
import com.atfcm.airportlogistics.service.FlyInfoService;
import com.atfcm.airportlogistics.service.UserRicipeService;
import com.atfcm.airportlogistics.service.UserSendService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    FlyInfoService flyInfoService;


    /*查看所有订单*/
    @RequestMapping("/orders")
    public String getALLOrders(Map<String, Object> map, @RequestParam(value = "pn", defaultValue = "0") Integer pn) {
        //紧跟他的查询就是分页查询
        PageHelper.startPage(pn, 10);
        List<OrderForm> orderForms = userSendService.selectAllSendRecip();
        PageInfo<OrderForm> info = new PageInfo<>(orderForms, 2);

        map.put("orderForms", orderForms);
        map.put("info", info);
        System.out.println(orderForms);

        return "admin/orders";
    }

    /*
        页面转发
     */
    @RequestMapping("/order")
    public String orderAdd(String orderNumber, Map<String, Object> map) {
        OrderForm orderForm = adminService.selectByOderNumber(orderNumber);
        map.put("orderForm", orderForm);
        if(orderNumber==null){
            return "admin/order-add";
        }else{
            return "admin/order-update";
        }

    }






    /**
     * 修改  start 字段
     *
     *开始发货 fly_info表插入记录
     */
    @PutMapping("/od/{orderNumber}")
    public String updateOrderForm(@PathVariable("orderNumber") String oderNumber, FlyInfo flyInfo) {
        userSendService.updateStartAndInserttFlyinfo(oderNumber,flyInfo);

        return "redirect:/orders";
    }

    /**
     * 删除订单
     *
     * @param oderNumber
     * @return
     */
    @DeleteMapping("/od/{oderNumber}")
    public String delete(@PathVariable("oderNumber") String oderNumber) {
        adminService.deleteOrder(oderNumber);
        return "redirect:/orders";

    }


    /*修改订单全字段*/
    @ResponseBody
    @PutMapping("/order")
    public ResultInfo Update(OrderForm orderForm, ResultInfo info) {
        userSendService.updateOrderForm(orderForm);
        info.setFlag(true);
        return info;

    }

    /*查询订单*/
    @ResponseBody
    @GetMapping("user/order")
    public ResultInfo getStatus(String orderNumber,ResultInfo info){

        String search = flyInfoService.orderSearch(orderNumber);
        if (search != null){
            info.setFlag(true);
            info.setData(search);
            System.out.println(search);
        }else {
            info.setFlag(false);
        }
        return info;

    }


}


