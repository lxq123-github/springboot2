package com.lxq.springboot;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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

/*    @Test
    public void whenQuerySuccess () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/order")
                .param("username","knyel")
                .param("age","18")
                .param("ageTo","60")
                .param("phone","110")
                .param("size","15")
                .param("page","2")
                .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("3"));//查询的根元素，例如$.length()代表整个传过来的json的文档
    }*/


/*
    @Test
    public void findAll() {
        List<OrderForm> orders = orderMapper.findAll();
        for(OrderForm order:orders){
            System.out.println(order);
        }
    }
    @Test
    public void findById() {
        OrderForm order = orderMapper.findById(3);
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
        List<OrderForm> orders = orderMapper.findAll();
        for(OrderForm order : orders){
            System.out.println(order);
        }
    }

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
