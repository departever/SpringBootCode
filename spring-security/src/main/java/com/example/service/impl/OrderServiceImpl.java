package com.example.service.impl;

import com.example.common.ParamsPage;
import com.example.common.ResultPage;
import com.example.domain.Order;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResultPage<Order> selectAllGoods(ParamsPage paramsPage) {
        if (paramsPage == null) {
            throw new RuntimeException("== paramsPage 该对像是空的");
        }
        // 设置分页参数
        PageHelper.startPage(paramsPage.getCurrentPage(),
                paramsPage.getPageSize());
        // 执行sql语句获取分页的数据
        List<Order> list = orderMapper.selectAllOrder(paramsPage.getSearchValue());
        // 对查询到的数据进行分页处理
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal(); // 获取总条数
        List<Order> li = pageInfo.getList(); // 获取分页数据
        // 将页面需要数据进行封装
        return new ResultPage<>(total, li);
    }

    @Override
    public List<String> searchHostGoods() {
        int size = 10;
        List<String> list = orderMapper.selectHostGoods(10);
        return list;
    }
}
