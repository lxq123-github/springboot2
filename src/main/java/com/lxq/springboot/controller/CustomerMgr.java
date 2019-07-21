package com.lxq.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户管理控制器
 */
@Controller
@RequestMapping(value="/customer")
@Api(value = "客户管理")
public class CustomerMgr {
    @Autowired
    private OrderService orderService;

    /**
     * 初始化日期类型
     * @param request
     * @param binder
     */
   @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

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
        PageInfo pageInfo= null;
        ModelAndView mv = new ModelAndView("order/show");
        mv.addObject("orders",pageInfo);
        return mv;
    }

}
