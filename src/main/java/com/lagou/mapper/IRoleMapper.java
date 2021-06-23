package com.lagou.mapper;

import com.lagou.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName IRoleMapper
 * @Description TODO
 * @Author mao
 * @Data 2021/6/23 10:04
 **/
public interface IRoleMapper {

    @Select("select * from sys_role r, sys_user_role ur where r.id=ur.roleid and ur.userid = #{uid}")
    public List<Role> findRoleByUid(Integer uid);
}
