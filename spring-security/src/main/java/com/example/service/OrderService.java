package com.example.service;

import com.example.common.ParamsPage;
import com.example.common.Result;
import com.example.common.ResultPage;
import com.example.domain.Order;

import java.util.List;

public interface OrderService {

    //根据分页参数从order表获取对应数据
    ResultPage<Order> selectAllGoods(ParamsPage paramsPage);

    List<String> searchHostGoods();
}
