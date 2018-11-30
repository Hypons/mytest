package com.itheima.dao;

import com.itheima.entity.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询全部用户
     */
    List<User> findAll();
}
