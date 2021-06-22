package com.lagou.mapper;

import com.lagou.pojo.Order;

import java.util.List;

/**
 * @ClassName IUserMapper
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 11:18
 **/
public interface IUserMapper {

    //查询订单的同事，还查询该订单所属用户
    public List<Order> findOrderAndUser();

}
