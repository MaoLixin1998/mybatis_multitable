package com.lagou.mapper;

import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName IUserMapper
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 11:18
 **/
public interface IOrderMapper {

    //查询订单的同事，还查询该订单所属用户
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid", javaType = User.class,
                    one = @One(select = "com.lagou.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser();


}
