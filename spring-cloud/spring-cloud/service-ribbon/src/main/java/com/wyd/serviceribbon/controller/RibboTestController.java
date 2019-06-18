package com.wyd.serviceribbon.controller;

import com.wyd.serviceribbon.service.impl.RibboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName :RibboTestController
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 18:14
 * @Version :1.0
 */
@RestController
public class RibboTestController {
    @Autowired
    private RibboService service;
    @RequestMapping("/test1")
    public Object test1(){
        System.out.println("ribbon");
        return service.eurekaClientTest1();
    }

}
