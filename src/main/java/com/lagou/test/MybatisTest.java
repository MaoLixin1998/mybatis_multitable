package com.lagou.test;

import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author mao
 * @Data 2021/6/22 15:02
 **/
public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //1.Resources工具类，配置文件的加载,把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2.解析了配置文件，并创建了sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.生产sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但事务不会自动提交
        //4.sqlSession调用方法
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);

        List<Order> orderAndUser = mapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }
    }

    @Test
    public void test2() throws IOException {
        //1.Resources工具类，配置文件的加载,把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2.解析了配置文件，并创建了sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.生产sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但事务不会自动提交
        //4.sqlSession调用方法
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }
}
