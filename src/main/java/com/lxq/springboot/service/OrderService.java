package com.lxq.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.form.OrderPojo;

/**
 * 订单服务层
 */
public interface OrderService {
    PageInfo findAll(int page, int pageSize) throws Exception;
    OrderPojo findById(int id) throws Exception;
    int findOrderCount() throws Exception;
    int deleteOrder(int id) throws Exception;
    int updateOrder(OrderPojo order) throws Exception;
    int saveOrder(OrderPojo order) throws Exception;
    void deleteBatch(String[] ids) throws Exception;
}
