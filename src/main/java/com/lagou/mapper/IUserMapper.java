package com.lagou.mapper;

import com.lagou.pojo.Role;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName IUserMapper
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 15:15
 **/
public interface IUserMapper {
    //查询所有用户信息以及用户关联的订单信息

    @Select("select * from `user`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "orderList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lagou.mapper.IOrderMapper.findOrderByUid"))
    })
    public List<User> findAll();

    //查询所有用户信息以及用户关联的角色信息
    @Select("select * from `user`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lagou.mapper.IRoleMapper.findRoleByUid"))
    })
    public List<User> findUserAndRole();

    @Insert("insert into `user` values(#{id},#{username})")
    public void addUser(User user);

    @Update("update user set username = #{username} where id = #{id}")
    public void updateUser(User user);

    @Select("select * from `user`")
    public List<User> selectUser();

    @Select("delete from `user` where id = #{id}")
    public List<User> deleteUser(Integer id);

    @Select("select * from user where id = #{id}")
    public User findUserById(Integer id);

}
