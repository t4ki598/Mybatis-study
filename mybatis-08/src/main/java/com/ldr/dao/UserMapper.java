package com.ldr.dao;

import com.ldr.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 项目名称：mybatis2
 * 类 名 称：UserMapper
 * 类 描 述：TODO
 * 创建时间：2020-03-04 10:40
 * 创 建 人：t4ki
 */
public interface UserMapper {
    List<User> getUser();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    //二级缓存测试
    User getCache(@Param("id") int id);
}
