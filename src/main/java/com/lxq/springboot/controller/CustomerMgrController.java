package com.lxq.springboot.controller;

import com.lxq.springboot.controller.common.InitController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 客户管理控制器
 */
@Controller
@RequestMapping(value="/customer")
@Api(value = "客户管理")
public class CustomerMgrController extends InitController {

    /**
     * 显示客户信息
     * @param pages
     * @return
     */
    @ApiOperation(value="显示客户信息", notes="根据页码显示订信息")
    @ApiImplicitParam(name = "pages", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView show(Integer pages){
        pages = pages==null?1:pages;
        ModelAndView mv = new ModelAndView("order/show");
        mv.addObject("customer",null);
        return mv;
    }

}
