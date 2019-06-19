package com.wyd.servicea.service.impl;

import com.wyd.servicea.service.ServiceA;
import org.springframework.stereotype.Service;

/**
 * @ClassName :ServiceAimpl
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/19 14:40
 * @Version :1.0
 */
@Service
public class ServiceAimpl implements ServiceA {

    public String get() {
        return "123";
    }

}
