package com.lxq.springboot.bo;

import lombok.Data;

/**
 * 返回页面结果信息的VO对象类
 */
@Data
public class ErrorInfo {
    private Integer code ;
    private String message ;
    private String url ;

}
