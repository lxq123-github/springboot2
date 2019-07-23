package com.lxq.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.form.OrderForm;
import com.lxq.springboot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理控制器
 */
@RestController
@RequestMapping(value="/order")
@Api(value = "订单管理控制器")
public class OrderMgrController {
    public static final String REDIRECT_ORDER = "redirect:/order";
    @Autowired
    private OrderService orderService;

    /**
     * 显示订单信息
     * @param id
     * @return
     */
    @ApiOperation(value="显示订单", notes="根据页码显示订单信息")
    @ApiImplicitParam(name = "id", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value="/list")
    public PageInfo show(@RequestParam(name="id", defaultValue="1") Integer id) throws Exception{
        return orderService.findAll(id,5);
    }

    /**
     * 显示一个订单信息
     * @param id
     * @return
     */
    @ApiOperation(value="显示一个订单", notes="根据订单ID显示一个信息")
    @ApiImplicitParam(name = "id", value = "订单", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value="/{id}")
    public OrderForm getOrder(@PathVariable Integer id) throws Exception{
        return orderService.findById(id);
    }

    /**
     * 删除一个订单
     * @param id
     * @return
     */
    @ApiOperation(value="删除订单", notes="根据订单ID删除信息")
    @ApiImplicitParam(name = "id", value = "订单ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping(value="/{id}")
    public int delete(@PathVariable Integer id) throws Exception{
        return orderService.deleteOrder(id);
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @ApiOperation(value="增加订单", notes="增加订单信息")
    @ApiImplicitParam(name = "order", value = "订单对象", required = true, dataType = "OrderForm", paramType = "path")
    @PostMapping
    public int save(OrderForm order) throws Exception{
        return orderService.saveOrder(order);
    }

    /**
     * 更新订单
     * @param order
     * @return
     */
    @ApiOperation(value="更新订单", notes="更新订单信息")
    @ApiImplicitParam(name = "order", value = "订单对象", required = true, dataType = "OrderForm", paramType = "path")
    @PutMapping
    public int update(OrderForm order) throws Exception{
        return orderService.updateOrder(order);
    }

/*    GET /ec2/instance/batch?id=aa,bb,cc：简约的设计
    GET /ec2/instance?batch={"ids":["aa","bb","cc"]}：健壮的设计
    GET /ec2/instance?batch=[{"method":"DELETE","id":"aa"},{"method":"DELETE","id":"bb"},{"method":"DELETE","id":"cc"}]：facebook 的设计（墙外）
    *//**
     * 批量删除订单
     * @param ids
     * @return
     *//*
    @ApiOperation(value="批量删除订单", notes="批量删除订单")
    @ApiImplicitParam(name = "ids", value = "String[]", required = true, dataType = "String[]", paramType = "path")
    @DeleteMapping
    public void batchDelete(String[] ids) throws Exception{
        orderService.deleteBatch(ids);
    }*/
}
