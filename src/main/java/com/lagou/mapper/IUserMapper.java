package com.lagou.mapper;

import com.lagou.pojo.Role;
import com.lagou.pojo.User;

import java.util.List;

/**
 * @ClassName IUserMapper
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 15:15
 **/
public interface IUserMapper {
    //查询所有用户信息以及用户关联的订单信息
    public List<User> findAll();
    //查询所有用户信息以及用户关联的角色信息
    public List<User> findUserAndRole();

}
