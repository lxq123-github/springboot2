package com.lxq.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.form.OrderForm;
import com.lxq.springboot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单管理控制器
 */
@Controller
@RequestMapping(value="/order")
@Api(value = "订单管理控制器")
public class OrderMgrController {
    public static final String REDIRECT_ORDER = "redirect:/order";
    @Autowired
    private OrderService orderService;

    /**
     * 显示订单信息
     * @param pages
     * @return
     */
    @ApiOperation(value="显示订单信息", notes="根据页码显示订单信息")
    @ApiImplicitParam(name = "pages", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
    @GetMapping
    public ModelAndView show(Integer pages) throws Exception{
        pages = pages==null?1:pages;
        PageInfo pageInfo= orderService.findAll(pages,5);
        ModelAndView mv = new ModelAndView("order/show");
        mv.addObject("orders",pageInfo);
        return mv;
    }

    /**
     * 跳转页
     * @param pages
     * @return
     */
    @ApiOperation(value="跳转订单信息", notes="根据页码跳转订单信息")
    @ApiImplicitParam(name = "pages", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/go/{pages}")
    public ModelAndView go(@PathVariable Integer pages) {
        pages = pages<1?1:pages;
        return new ModelAndView(REDIRECT_ORDER + "?pages="+pages);
    }

    /**
     * 删除一个订单
     * @param oid
     * @return
     */
    @ApiOperation(value="删除订单ID信息", notes="根据页码删除订单信息")
    @ApiImplicitParam(name = "pages", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value="/delete/{oid}")
    public ModelAndView delete(@PathVariable Integer oid) throws Exception{
        orderService.deleteOrder(oid);
        return new ModelAndView(REDIRECT_ORDER);
    }

    /**
     * 跳转更新订单
     * @param oid
     * @return
     */
    @ApiOperation(value="更新订单ID信息", notes="根据页码更新订单信息")
    @ApiImplicitParam(name = "oid", value = "当前订单id", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value="/update/{oid}")
    public ModelAndView update(@PathVariable Integer oid) throws Exception{
        OrderForm order = orderService.findById(oid);
        ModelAndView mv = new ModelAndView("order/update");
        mv.addObject("order",order);
        return mv;
    }

    /**
     * 跳转添加订单
     * @return
     */
    @ApiOperation(value="跳转add页面", notes="跳转add页面")
    @GetMapping(value="/add")
    public String add() throws Exception{
        return "order/add";
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @ApiOperation(value="更新订单信息", notes="更新订单信息")
    @ApiImplicitParam(name = "order", value = "订单对象", required = true, dataType = "OrderPojo", paramType = "path")
    @PostMapping(value="/updateDate")
    public String save(OrderForm order) throws Exception{
        if(order.getOrderId()!=null)
            orderService.updateOrder(order);
        else
            orderService.saveOrder(order);
        return REDIRECT_ORDER;
    }

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    @ApiOperation(value="删除订单", notes="删除订单")
    @ApiImplicitParam(name = "ids", value = "String[]", required = true, dataType = "String[]", paramType = "path")
    @PostMapping(value="/batchDelete")
    public String batchDelete(String[] ids) throws Exception{
        orderService.deleteBatch(ids);
        return REDIRECT_ORDER;
    }
}
