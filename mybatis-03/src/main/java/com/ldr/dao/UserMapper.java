package com.ldr.dao;

import com.ldr.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);

    //分页1
    List<User> getUserByLimit(Map<String, Integer> map);

    //分页2：通过rowBounds
    //不使用SQL语句
    List<User> getUserByRowBounds();
}
