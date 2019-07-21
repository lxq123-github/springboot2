package com.lxq.springboot.controller.controller;

import com.lxq.springboot.controller.common.InitController;
import com.lxq.springboot.form.UrlPojo;
import com.lxq.springboot.service.impl.UrlServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/***
 * 主页面控制器ModelAttribute
 */
@Controller
@RequestMapping(value="/index")
@Api(value = "主页加载页面")
public class MainPageController extends InitController {
    @Autowired
    private UrlServiceImpl urlService;

    /**
     * 主页面显示
     * @return index.jsp
     */
    @ApiOperation(value="主页面显示", notes="")
    @RequestMapping(method = RequestMethod.GET)
    public String index() throws Exception{
        return "index";
    }

    /**
     * 页面头显示
     * @return view/top.jsp
     */
    @ApiOperation(value="页面头显示", notes="")
    @RequestMapping(value="/top",method = RequestMethod.GET)
    public String top() throws Exception{
        return "view/top";
    }

    /**
     * 左页面显示
     * @return view/left.jsp
     */
    @ApiOperation(value="左页面显示", notes="")
    @RequestMapping(value="/left",method = RequestMethod.GET)
    public ModelAndView left() throws Exception{
        List<UrlPojo> urls = urlService.findAllUrl();
        ModelAndView mv = new ModelAndView("view/left");
        mv.addObject("urls",urls);
        return mv;
    }
}
