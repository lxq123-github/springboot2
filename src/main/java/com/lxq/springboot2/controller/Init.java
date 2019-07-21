package com.lxq.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/index")
public class Init {
    @RequestMapping
    public String init(){
        return "index";
    }
}
