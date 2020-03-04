package com.ldr.dao;

import com.ldr.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * 项目名称：mybatis2
 * 类 名 称：BlogMapper
 * 类 描 述：TODO
 * 创建时间：2020-03-03 17:13
 * 创 建 人：t4ki
 */
public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客

    //动态sql之if
    List<Blog> queryBlogIf(Map map);

    //动态sql之choose
    List<Blog> queryBlogChoose(Map map);

    //更新博客，动态sql之set
    int updateBlogSet(Map map);

    //动态sql之foreach
    List<Blog> queryBlogForeach(Map map);

}
