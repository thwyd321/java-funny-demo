package com.wyd.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName :RibboService
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 19:36
 * @Version :1.0
 */
@Service
public class RibboService {

    @Autowired
    private RestTemplate template;

    /**
     * 使用Hystrix 熔断，当服务不可用时调用error方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String eurekaClientTest1() {
        return template.getForObject("http://eureka-client/test1", String.class);

    }
    public String error(){
        return "错误";
    }

}
