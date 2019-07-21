package com.lxq.springboot.controller;

import lombok.Data;

@Data
public class ErrorInfo {
    private Integer code ;
    private String message ;
    private String url ;

}
