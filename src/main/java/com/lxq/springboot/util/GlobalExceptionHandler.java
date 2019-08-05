package com.lxq.springboot.util;

import com.lxq.springboot.bo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ControllerAdvice 注解定义全局异常处理类 ，@ExceptionHandler 注解声明异常处理方法。
 */
//增强型控制器，对于控制器的全局配置放在同一个位置，全局异常的注解，放在类上
@ControllerAdvice
public class GlobalExceptionHandler {

  private static final String DEFAULT_ERROR_VIEW = "error";

  @ExceptionHandler(Exception.class) // 指明需要处理的异常类型以及子类。注解放在方法上面
  public ModelAndView defaultErrorHandler(HttpServletRequest request,
      Exception e) { // 出现异常之后会跳转到此方法
    ModelAndView mv = new ModelAndView(DEFAULT_ERROR_VIEW);
    ErrorInfo info = new ErrorInfo();
    info.setCode(100);     // 标记一个错误信息类型
    info.setMessage(e.getMessage());
    info.setUrl(request.getRequestURL().toString());
    mv.addObject("info", info);
    return mv;
  }
}
