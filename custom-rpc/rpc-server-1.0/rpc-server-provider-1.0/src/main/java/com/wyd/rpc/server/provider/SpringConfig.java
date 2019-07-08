package com.wyd.rpc.server.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.wyd")
public class SpringConfig {

    @Bean(name="rpcServer")
    public RpcServer getRpcServer(){
        return new RpcServer(8080);
    }
}
