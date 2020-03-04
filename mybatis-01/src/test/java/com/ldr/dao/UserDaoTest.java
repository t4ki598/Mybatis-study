package com.ldr.dao;

import com.ldr.pojo.User;
import com.ldr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date 2020/02/04
 */
public class UserDaoTest {

    @Test
    public void test(){
        //获取sqlsession对象，这步是死的，必须写
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for(User user : userList){
            System.out.println(user);
        }

        //关闭sqlsesiion，这步也是写死的。
        sqlSession.close();
    }


    //根据id查询
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }


    //根据名字模糊查询
    //写模糊查询的时候，java代码执行加通配符% %
    @Test
    public void getUserByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserByName("%l%");
        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.addUser(new User(5,"haha","343434"));
        if(res > 0){
            System.out.println("增加成功");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(4, "xixi","123123"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(5);

        sqlSession.commit();
        sqlSession.close();
    }
}
