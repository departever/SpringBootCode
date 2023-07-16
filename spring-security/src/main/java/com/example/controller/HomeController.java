package com.example.controller;

import com.example.common.ParamsPage;
import com.example.common.Result;
import com.example.common.ResultPage;
import com.example.domain.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/findOrdersPage")
    public ResultPage<Order> selectAllGoods(@RequestBody ParamsPage paramsPage){
        System.out.println("paramsPage = " + paramsPage);
        ResultPage<Order> page = orderService.selectAllGoods(paramsPage);
        return page;
    }

    @RequestMapping("/searchHostGoods")
    public List<String> searchHostGoods(){
        List<String> list = orderService.searchHostGoods();
        return list;
    }
}
