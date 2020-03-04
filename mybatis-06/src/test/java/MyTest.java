import com.ldr.dao.TeacherMapper;
import com.ldr.pojo.Teacher;
import com.ldr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 项目名称：mybatis2
 * 类 名 称：MyTest
 * 类 描 述：TODO
 * 创建时间：2020-03-03 16:03
 * 创 建 人：t4ki
 */
public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();

    }
}
