package com.lxq.springboot.entity;

import lombok.Data;

/**
 * URL实体类
 */
@Data
public class Url {
    //ID
    private Integer id;
    // URL Name
    private String name;
    // URL
    private String url;
    // 说明
    private String comment;
}
