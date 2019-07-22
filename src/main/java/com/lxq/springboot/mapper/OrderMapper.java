package com.lxq.springboot.mapper;

import com.lxq.springboot.form.OrderForm;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单数据库操作
 */
@Mapper
public interface OrderMapper {

    List<OrderForm> findAll();

    OrderForm findById(int id);

    int findOrderCount();

    int deleteOrder(int id);

    int updateOrder(OrderForm order);

    int insert(OrderForm order);

    void deleteBatch(String[] ids);
}