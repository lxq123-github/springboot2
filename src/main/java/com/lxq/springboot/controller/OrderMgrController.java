package com.lxq.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.form.OrderForm;
import com.lxq.springboot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理控制器
 */
@RestController
@RequestMapping(value = "/orders")
@Api(value = "订单管理控制器")
public class OrderMgrController {

  public static final String REDIRECT_ORDER = "redirect:/orders";
  @Autowired
  private OrderService orderService;

  /**
   * 显示订单信息
   */
  @ApiOperation(value = "显示订单列表", notes = "根据请求的页码显示订单信息")
  @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType = "path")
  @GetMapping(value = "/list")
  public ResponseEntity<PageInfo> listAll(@RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    PageInfo pageInfo = orderService.findAll(pageNum, 5);
    return new ResponseEntity<>(pageInfo, HttpStatus.OK);
  }

  /**
   * 显示一个订单信息
   */
  @ApiOperation(value = "显示一个订单", notes = "根据订单ID显示一个信息")
  @ApiImplicitParam(name = "id", value = "订单Id", required = true, dataType = "Integer", paramType = "path")
  @GetMapping(value = "/{id}")
  public ResponseEntity<OrderForm> getOrder(@PathVariable Integer id) throws Exception {
    OrderForm order = orderService.findById(id);
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  /**
   * 删除一个订单
   */
  @ApiOperation(value = "删除订单", notes = "根据订单ID删除信息")
  @ApiImplicitParam(name = "id", value = "订单ID", required = true, dataType = "Integer", paramType = "path")
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Integer> delete(@PathVariable Integer id) throws Exception {
    int result = orderService.deleteOrder(id);
    return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
  }

  /**
   * 添加订单
   */
  @ApiOperation(value = "增加订单", notes = "根据客户端发来的body请求进行增加订单")
  @ApiImplicitParam(name = "orderForm", value = "订单对象", required = true, dataType = "OrderForm", paramType = "path")
  @PostMapping
  public ResponseEntity<String> saveOrder(@RequestBody OrderForm orderForm) throws Exception {
    if ("update".equals(orderForm.getMethod())) {
      orderService.saveOrder(orderForm);
      return new ResponseEntity<>(HttpStatus.CREATED);  //201
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
  }

  /**
   * 更新订单
   */
  @ApiOperation(value = "更新订单", notes = "根据客户端发来的body请求进行更新订单")
  @ApiImplicitParam(name = "orderForm", value = "订单对象", required = true, dataType = "OrderForm", paramType = "path")
  @PutMapping
  public ResponseEntity<String> updateOrder(@RequestBody OrderForm orderForm) throws Exception {
    if ("update".equals(orderForm.getMethod())) {
      orderService.updateOrder(orderForm);
      return new ResponseEntity<>(HttpStatus.CREATED);  //201
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
  }

  /**
   * 批量删除订单
   */
  @ApiOperation(value = "批量删除订单", notes = "根据客户端发来的body请求体进行批量删除订单")
  @ApiImplicitParam(name = "orderForm", value = "订单对象", required = true, dataType = "OrderForm", paramType = "path")
  @DeleteMapping(value = "/batch")
  public ResponseEntity<String> batchDeleteOrder(@RequestBody OrderForm orderForm)
      throws Exception {
    if ("deleteBatch".equals(orderForm.getMethod())) {
      orderService.deleteBatch(orderForm.getIds());
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);  //204
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
  }
}
