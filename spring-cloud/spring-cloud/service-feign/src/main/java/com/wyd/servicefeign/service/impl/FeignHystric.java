package com.wyd.servicefeign.service.impl;

import com.wyd.servicefeign.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @ClassName :FeignHystric
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/17 19:52
 * @Version :1.0
 */
@Component
public class FeignHystric implements FeignService {

    @Override
    public String eurekaClientTest() {
        return "error";
    }
}
