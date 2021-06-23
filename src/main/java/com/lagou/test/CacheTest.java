package com.lagou.test;

import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName CacheTest
 * @Description TODO
 * @Author mao
 * @Data 2021/6/23 10:13
 **/
public class CacheTest {
    private IUserMapper userMapper;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //1.Resources工具类，配置文件的加载,把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2.解析了配置文件，并创建了sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.生产sqlSession
        sqlSession = sqlSessionFactory.openSession(true);//默认开启一个事务，但事务不会自动提交
        //4.sqlSession调用方法
        userMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @Test
    public void firstLevelCache(){
        //第一次查询id为1的用户
        User user1 = userMapper.findUserById(1);
        User user2 = userMapper.findUserById(1);
        System.out.println( user1 == user2);
    }


}
