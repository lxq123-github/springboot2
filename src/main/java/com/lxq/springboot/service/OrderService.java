package com.lxq.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.form.OrderForm;

/**
 * 订单服务层
 */
public interface OrderService {
    PageInfo findAll(int page, int pageSize) throws Exception;
    OrderForm findById(int id) throws Exception;
    int findOrderCount() throws Exception;
    int deleteOrder(int id) throws Exception;
    int updateOrder(OrderForm order) throws Exception;
    int saveOrder(OrderForm order) throws Exception;
    void deleteBatch(String[] ids) throws Exception;
}
