package com.example.mapper;

import com.example.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> selectAllOrder(@Param("title") String title);

    List<String> selectHostGoods(int i);
}
