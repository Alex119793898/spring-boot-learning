package com.caoliang.springboot.logging.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello ! this is springboot project";
    }

    @GetMapping("/hello1")
    @ResponseBody
    public String hello1(HttpServletRequest request, HttpServletResponse response, String name){
        return request.getRequestURI() + "---" + name + "---" +response.getStatus();
    }

    @GetMapping("/log")
    @ResponseBody
    public String log(HttpServletRequest request, HttpServletResponse response, String name){

        logger.debug("这是一条 debug 级别日志");
        logger.info("这是一条 info 级别日志");
        logger.warn("这是一条 warn 级别日志");
        logger.error("这是一条 error 级别日志");
        return "日志打印";
    }
}
