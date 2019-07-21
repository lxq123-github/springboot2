package com.lxq.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.lxq.springboot.controller.common.InitController;
import com.lxq.springboot.form.OrderPojo;
import com.lxq.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单管理控制器
 */
@Controller
@RequestMapping(value="/order")
public class OrderMgrController extends InitController {
    @Autowired
    private OrderService orderService;

    /**
     * 显示订单信息
     * @param pages
     * @return
     */
    @RequestMapping(method= RequestMethod.GET)
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
    @RequestMapping(value = "/go/{pages}",method= RequestMethod.GET)
    public ModelAndView go(@PathVariable Integer pages) throws Exception{
        pages = pages<1?1:pages;
        ModelAndView mv = new ModelAndView("redirect:/order?pages="+pages);
        return mv;
    }

    /**
     * 删除一个订单
     * @param oid
     * @return
     */
    @RequestMapping(value="/delete/{oid}",method= RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer oid) throws Exception{
        int rsid = orderService.deleteOrder(oid);
        System.out.println(rsid);
        ModelAndView mv = new ModelAndView("redirect:/order");
        return mv;
    }

    /**
     * 跳转更新订单
     * @param oid
     * @return
     */
    @RequestMapping(value="/update/{oid}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Integer oid) throws Exception{
        OrderPojo order = orderService.findById(oid);
        ModelAndView mv = new ModelAndView("order/update");
        mv.addObject("order",order);
        return mv;
    }

    /**
     * 跳转添加订单
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add() throws Exception{
        return "order/add";
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping(value="/updateDate",method = RequestMethod.POST)
    public String save(OrderPojo order) throws Exception{
        if(order.getOrderId()!=null)
            orderService.updateOrder(order);
        else
            orderService.saveOrder(order);
        return "redirect:/order";
    }

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    @RequestMapping(value="/batchDelete",method = RequestMethod.POST)
    public String batchDelete(String[] ids) throws Exception{
        orderService.deleteBatch(ids);
        return "redirect:/order";
    }
}
