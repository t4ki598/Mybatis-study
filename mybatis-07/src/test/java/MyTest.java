import com.ldr.dao.BlogMapper;
import com.ldr.pojo.Blog;
import com.ldr.utils.IDUtils;
import com.ldr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 项目名称：mybatis2
 * 类 名 称：MyTest
 * 类 描 述：TODO
 * 创建时间：2020-03-03 17:30
 * 创 建 人：t4ki
 */
public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setAuthor("ldr");
        blog.setCreate_time(new Date());
        blog.setTitle("t4ki");
        blog.setViews(10);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("第二集");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("第三集");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("第四集");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIfTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        map.put("title", "第二集");
        map.put("author", "ldr");

        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        //如果条件都满足，只会走第一个
        map.put("views", "10");
        map.put("title", "t4ki");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogSetTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id", "1a70485e4c4f429fac3746440fd33e07");
        map.put("views", 90);
        mapper.updateBlogSet(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeachTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<String>();
        //ids.add("1");
        ids.add("f");
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
