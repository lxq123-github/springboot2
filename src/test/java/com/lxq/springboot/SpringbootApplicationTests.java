package com.lxq.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Resource
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void batchDeleteOrder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/orders/batch")
                .content("{\"method\": \"deleteBatch\", \"ids\": [1, 2, 3] }")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void updateOrder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/orders")
                .content("{\"method\":\"update\",\"data\":[],\"orderId\":\"1\",\"clientId\":\"1001\",\"orderDate\":\"2019-07-24\",\"quantity\":\"1000\",\"commont\":\"abcd\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveOrder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                .content("{\"method\":\"save\",\"data\":[],\"orderId\":\"1\",\"clientId\":\"1001\",\"orderDate\":\"2019-07-24\",\"quantity\":\"1000\",\"commont\":\"abcd\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/orders/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getOrder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void listAll () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/list?pageNum=2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

/*
    @Test
    public void findAll() {
        List<OrderForm> orders = orderMapper.findAll();
        for(OrderForm orders:orders){
            System.out.println(orders);
        }
    }
    @Test
    public void findById() {
        OrderForm orders = orderMapper.findById(3);
        System.out.println(orders);
    }

    @Test
    public void findOrderCount(){
        int orderCount = orderMapper.findOrderCount();
        System.out.println("count = " + orderCount);
    }
    @Test
    public void testPagehelper(){
        PageHelper.startPage(2,2);
        List<OrderForm> orders = orderMapper.findAll();
        for(OrderForm orders : orders){
            System.out.println(orders);
        }
    }

	@Test
	public void deleteOrder(){
		System.out.println("删除为：" + orderMapper.deleteOrder(9));
	}

	@Test
	public void updateOrder(){
		OrderPojo orders = new orders();
		orders.setOrderId(8);
		orders.setClientId("1008");
		orders.setOrderDate(new Date());
		orders.setQuantity("1000");
		orders.setCommont("xxxx");
		System.out.println("更新为：" + orderMapper.updateOrder(orders));
	}

	@Test
	public void saveOrder(){
		OrderPojo orders = new orders();
		orders.setClientId("1009");
		orders.setOrderDate(new Date());
		orders.setQuantity("1000");
		orders.setCommont("aaaa");
		System.out.println("输出为："+orderMapper.insert(orders));
		System.out.println("插入ID为：" +orders.getOrderId());
	}*/
}
