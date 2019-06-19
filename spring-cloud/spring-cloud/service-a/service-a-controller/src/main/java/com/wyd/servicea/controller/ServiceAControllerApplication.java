package com.wyd.servicea.controller;

import com.wyd.servicea.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.wyd.servicea"})
@RestController
public class ServiceAControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAControllerApplication.class, args);
    }
    @Value("${server.port}")
    String port;

    @Autowired
    private ServiceA serviceA;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/get")
    public String get(){
        return serviceA.get();
    }
}
