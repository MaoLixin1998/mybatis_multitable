package com.lagou.mapper;

import com.lagou.pojo.Role;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
