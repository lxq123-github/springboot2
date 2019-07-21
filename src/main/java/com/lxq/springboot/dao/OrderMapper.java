package com.lxq.springboot.dao;

import com.lxq.springboot.pojo.OrderPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单数据库操作
 */
@Mapper
public interface OrderMapper {
    @Select("select * from spring.`order`")
    List<OrderPojo> findAll();
    @Select("select * from spring.`order` where orderId=#{orderId}")
    OrderPojo findById(int id);
    @Select("select count(*) from spring.`order`")
    int findOrderCount();
    @Delete("delete from spring.`order` where orderId=#{orderId}")
    int deleteOrder(int id);
    @Update("update spring.`order` set clientId = #{clientId},orderDate=#{orderDate},quantity=#{quantity},commont=#{commont} where orderId=#{orderId}")
    int updateOrder(OrderPojo order);
    @Insert("insert into spring.`order`(clientId,orderDate,quantity,commont) values(#{clientId},#{orderDate},#{quantity},#{commont})")
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
    int insert(OrderPojo order);
    @Delete("<script>delete from spring.`order` where orderId in <foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach></script>")
    void deleteBatch(String[] ids);
}