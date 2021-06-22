package com.lagou.pojo;

/**
 * @ClassName Order
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 11:15
 **/
public class Order {

    private Integer id;
    private String orderTime;
    private Double total;

    //该订单属于哪个用户
    private User user;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime='" + orderTime + '\'' +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
