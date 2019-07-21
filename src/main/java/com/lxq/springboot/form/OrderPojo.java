package com.lxq.springboot.form;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 */
@Data
public class OrderPojo implements Serializable {
    //订单ID
    private Integer orderId;
    //客户ID
    private String clientId;
    //订单日期
    private Date orderDate;
    //订单数量
    private String quantity;
    //说明
    private String commont;

}