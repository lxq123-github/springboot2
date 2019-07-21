package com.lxq.springboot;

import com.github.pagehelper.PageHelper;
import com.lxq.springboot.dao.OrderMapper;
import com.lxq.springboot.form.OrderPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Resource
    private OrderMapper orderMapper;
    @Test
    public void findAll() {
        List<OrderPojo> orders = orderMapper.findAll();
        for(OrderPojo order:orders){
            System.out.println(order);
        }
    }
    @Test
    public void findById() {
        OrderPojo order = orderMapper.findById(3);
        System.out.println(order);
    }

    @Test
    public void findOrderCount(){
        int orderCount = orderMapper.findOrderCount();
        System.out.println("count = " + orderCount);
    }
    @Test
    public void testPagehelper(){
        PageHelper.startPage(2,2);
        List<OrderPojo> orders = orderMapper.findAll();
        for(OrderPojo order : orders){
            System.out.println(order);
        }
    }
/*
	@Test
	public void deleteOrder(){
		System.out.println("删除为：" + orderMapper.deleteOrder(9));
	}

	@Test
	public void updateOrder(){
		OrderPojo order = new Order();
		order.setOrderId(8);
		order.setClientId("1008");
		order.setOrderDate(new Date());
		order.setQuantity("1000");
		order.setCommont("xxxx");
		System.out.println("更新为：" + orderMapper.updateOrder(order));
	}

	@Test
	public void saveOrder(){
		OrderPojo order = new Order();
		order.setClientId("1009");
		order.setOrderDate(new Date());
		order.setQuantity("1000");
		order.setCommont("aaaa");
		System.out.println("输出为："+orderMapper.insert(order));
		System.out.println("插入ID为：" +order.getOrderId());
	}*/
}
