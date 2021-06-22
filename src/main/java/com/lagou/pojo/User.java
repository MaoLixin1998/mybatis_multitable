package com.lagou.pojo;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 11:12
 **/
public class User {

    private Integer id;

    private String username;

    //该用户所具有的订单信息
    private List<Order> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
