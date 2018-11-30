package com.itheima;

import com.itheima.dao.IUserDao;
import com.itheima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // 1.加载文件流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建工厂的构造器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.通过构造器，创建SqlSessionFactory的工厂
        SqlSessionFactory factory = builder.build(inputStream);
        // 4.通过工厂创建SqlSessoion对象
        SqlSession sqlSession = factory.openSession();
        // 5.生成接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 6.执行代理的方法
        // class com.sun.proxy.$Proxy2 implements IUserDao
        // IUserDao userDao = $Proxy2;
        System.out.println(userDao.getClass());
        List<User> list = userDao.findAll();
        System.out.println(list);

        // 7. 提交事务/关闭释放资源
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}















