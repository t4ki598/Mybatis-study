package com.ldr.dao;

import com.ldr.pojo.User;
import com.ldr.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date 2020/02/04
 */
public class UserDaoTest {

    //在要使用Log4j 的类中，导入org.apache.log4j.Logger;
    //日志对象，加载参数为当前类的class
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test() {
        //获取sqlsession对象，这步是死的，必须写
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(2);

        System.out.println(user);

        //关闭sqlsesiion，这步也是写死的。
        sqlSession.close();
    }

    @Test
    public void log4jTest(){

        //日志级别
        logger.info("info:进入Testlog4j");
        logger.debug("debug:进入Testlog4j");
        logger.error("error:进入Testlog4j");
    }

    @Test
    public void getUserByLimitTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize", 2);

        List<User> userList = userMapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        RowBounds的实现
        RowBounds rowBounds = new RowBounds(1,2);

//        通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.ldr.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
