package com.packy.springcloud.order_service.domain;

import java.util.Date;

public class ProductOrder {
    private int id;
    private String productName;
    private int price;
    private Date createTime;
    private String tradeNo;
    private int userId;
    private String userName;

    public ProductOrder() {
    }

    public ProductOrder(int id, String productName, int price, Date createTime, String tradeNo, int userId, String userName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.createTime = createTime;
        this.tradeNo = tradeNo;
        this.userId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
