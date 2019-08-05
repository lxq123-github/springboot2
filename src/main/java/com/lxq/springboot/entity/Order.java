package com.lxq.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单实体类
 */
@Data
public class Order implements Serializable {

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