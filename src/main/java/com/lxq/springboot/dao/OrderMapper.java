package com.lxq.springboot.dao;

import com.lxq.springboot.form.OrderPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单数据库操作
 */
@Mapper
public interface OrderMapper {

    List<OrderPojo> findAll();

    OrderPojo findById(int id);

    int findOrderCount();

    int deleteOrder(int id);

    int updateOrder(OrderPojo order);

    int insert(OrderPojo order);

    void deleteBatch(String[] ids);
}