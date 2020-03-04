import com.ldr.dao.UserMapper;
import com.ldr.pojo.User;
import com.ldr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 项目名称：mybatis2
 * 类 名 称：MyTest
 * 类 描 述：TODO
 * 创建时间：2020-03-04 10:44
 * 创 建 人：t4ki
 */
public class MyTest {
    @Test
    public void getUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        //手动清理缓存
        sqlSession.clearCache();
        System.out.println("------------------");
        User user1 = mapper.getUserById(2);
        System.out.println(user == user1);
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(2, "whta", "358214"));
    }

    @Test
    public void getCacheTest(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.getCache(1);
        System.out.println(user1);
        //关闭后一级缓存失效，数据被写入二级缓存
        sqlSession1.close();


        System.out.println("--------------");


        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.getCache(1);
        System.out.println(user2);

        //开启二级缓存后，去二级缓存读取数据，而不是去数据库读取
        System.out.println(user1 == user2);
        sqlSession2.close();

    }
}
