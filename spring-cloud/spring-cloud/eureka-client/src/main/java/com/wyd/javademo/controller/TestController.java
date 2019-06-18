package com.wyd.javademo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName :TestController
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 17:35
 * @Version :1.0
 */
@RestController
@Log4j2
public class TestController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/test1")
    public Object test1() {
        log.info(port);
        return new ResponseEntity(port, HttpStatus.OK);
    }


}
