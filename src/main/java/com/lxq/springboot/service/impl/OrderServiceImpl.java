package com.lxq.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxq.springboot.mapper.OrderMapper;
import com.lxq.springboot.form.OrderForm;
import com.lxq.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单服务层实现
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED, readOnly = true)
    public PageInfo findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        List<OrderForm> orders = orderMapper.findAll();
        return new PageInfo(orders);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED, readOnly = true)
    public OrderForm findById(int id) throws Exception {
        return orderMapper.findById(id);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED, readOnly = true)
    public int findOrderCount() throws Exception {
        return orderMapper.findOrderCount();
    }

    @Override
    public int deleteOrder(int id) throws Exception {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public int updateOrder(OrderForm order) throws Exception {
        return orderMapper.updateOrder(order);
    }

    @Override
    public int saveOrder(OrderForm order)  throws Exception{
        return orderMapper.insert(order);
    }

    @Override
    public void deleteBatch(String[] ids)  throws Exception{
        orderMapper.deleteBatch(ids);
    }
}
