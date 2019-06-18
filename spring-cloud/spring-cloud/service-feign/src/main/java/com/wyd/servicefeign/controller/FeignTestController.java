package com.wyd.servicefeign.controller;

import com.wyd.servicefeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :FeignTestController
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 18:45
 * @Version :1.0
 */
@RestController
public class FeignTestController {
    @Autowired
    private FeignService eurekaClientService;
    @RequestMapping("/test2")
    public Object test2(){
        System.out.println("feign");
        String s = eurekaClientService.eurekaClientTest();
        return s;
    }

}
