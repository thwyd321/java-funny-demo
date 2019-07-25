package com.wyd.design.proxy.statice2.entity;

/**
 * @ClassName :Order
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 11:19
 * @Version :1.0
 */
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
