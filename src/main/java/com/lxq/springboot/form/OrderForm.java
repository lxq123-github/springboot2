package com.lxq.springboot.form;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 */
@Data
public class OrderForm implements Serializable {

  // body请求体中method
  private String method;
  // body请求体中多个id
  private String[] ids;

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