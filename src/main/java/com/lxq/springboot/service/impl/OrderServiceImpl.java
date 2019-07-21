package com.lxq.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxq.springboot.dao.OrderMapper;
import com.lxq.springboot.pojo.OrderPojo;
import com.lxq.springboot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务层实现
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public PageInfo findAll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OrderPojo> orders = orderMapper.findAll();
        PageInfo pageInfo = new PageInfo(orders);
        return pageInfo;
    }

    @Override
    public OrderPojo findById(int id) {
        return orderMapper.findById(id);
    }

    @Override
    public int findOrderCount() {
        return orderMapper.findOrderCount();
    }

    @Override
    public int deleteOrder(int id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public int updateOrder(OrderPojo order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public int saveOrder(OrderPojo order) {
        return orderMapper.insert(order);
    }

    @Override
    public void deleteBatch(String[] ids) {
        orderMapper.deleteBatch(ids);
    }
}
