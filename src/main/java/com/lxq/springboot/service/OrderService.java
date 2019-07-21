package com.lxq.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.pojo.OrderPojo;

/**
 * 订单服务层
 */
public interface OrderService {
    PageInfo findAll(int page, int pageSize);
    OrderPojo findById(int id);
    int findOrderCount();
    int deleteOrder(int id);
    int updateOrder(OrderPojo order);
    int saveOrder(OrderPojo order);
    void deleteBatch(String[] ids);
}
