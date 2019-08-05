package com.lxq.springboot.form;

import lombok.Data;

/**
 * URL实体类
 */
@Data
public class UrlForm {

  //ID
  private Integer id;
  // URL Name
  private String name;
  // URL
  private String urlName;
  // 说明
  private String comment;
}
