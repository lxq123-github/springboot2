package com.lxq.springboot.form;

import lombok.Data;

/**
 * URL实体类
 */
@Data
public class UrlPojo {
    //ID
    private Integer id;
    // URL Name
    private String name;
    // URL
    private String url;
    // 说明
    private String comment;
}
