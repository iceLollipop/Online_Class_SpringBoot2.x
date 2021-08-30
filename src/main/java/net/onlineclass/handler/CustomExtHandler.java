package net.onlineclass.handler;

import net.onlineclass.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice   //前后端分离项目，对异常信息进行处理，返回Format之后的报错信息
@ControllerAdvice       //前后端不分离项目，网站报错跳转异常页面
public class CustomExtHandler {

//    @ExceptionHandler(value=Exception.class)
//    JsonData exceptionHandler(Exception e, HttpServletRequest request){
//        return JsonData.buildError(-2,"服务端异常");
//    }


    @ExceptionHandler(value=Exception.class)
    Object exceptionHandler(Exception e, HttpServletRequest request){
        System.out.println("TEST");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        //给页面添加可以用到的属性值
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }
}
