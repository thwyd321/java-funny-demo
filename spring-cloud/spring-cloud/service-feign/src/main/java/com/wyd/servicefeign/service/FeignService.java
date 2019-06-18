package com.wyd.servicefeign.service;

import com.wyd.servicefeign.service.impl.FeignHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName :EurekaClientService
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 18:39
 * @Version :1.0
 */
@FeignClient(value = "eureka-client",fallback = FeignHystric.class)
public interface FeignService {
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    String eurekaClientTest();
}
