package com.wyd.design.strategy.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName :PayStrategyFactory
 * @Description :
 * 支付策略工厂
 * @Author : wangyudi
 * @Date : 2019/7/30 14:01
 * @Version :1.0
 */
public class PayStrategyFactory {

    private static Map<String,Pay> map = new HashMap<String, Pay>();

    static {
        map.put("1",new Alipay());
        map.put("2",new WechatPay());
    }

    public static Pay getBean(String payMethod){
        return map.get(payMethod);
    }

}
