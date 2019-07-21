package com.lxq.springboot.controller;

import com.lxq.springboot.pojo.UrlPojo;
import com.lxq.springboot.service.UrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/***
 * 主页面控制器ModelAttribute
 */
@Controller
@RequestMapping(value="/index")
@Api(value = "主页加载页面")
public class MainPage {
    @Resource
    private UrlService urlService;

    /**
     * 主页面显示
     * @return index.jsp
     */
    @ApiOperation(value="主页面显示", notes="")
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 页面头显示
     * @return view/top.jsp
     */
    @ApiOperation(value="页面头显示", notes="")
    @RequestMapping(value="/top",method = RequestMethod.GET)
    public String top(){
        return "view/top";
    }

    /**
     * 左页面显示
     * @return view/left.jsp
     */
    @ApiOperation(value="左页面显示", notes="")
    @RequestMapping(value="/left",method = RequestMethod.GET)
    public ModelAndView left(){
        List<UrlPojo> urls = urlService.findAllUrl();
        ModelAndView mv = new ModelAndView("view/left");
        mv.addObject("urls",urls);
        return mv;
    }
}
