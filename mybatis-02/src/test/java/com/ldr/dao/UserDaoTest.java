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
    public void test() {
        //获取sqlsession对象，这步是死的，必须写
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlsesiion，这步也是写死的。
        sqlSession.close();
    }

}
