package com.rui;

import com.rui.dao.BlogMapper;
import com.rui.pojo.Blog;
import com.rui.utils.IDUtils;
import com.rui.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void InitBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("尹锐");
        blog.setCreatTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<String, Object>();
        map.put("views", 9999);
        map.put("author", "尹锐3");
        map.put("title", "Java如此简单4");
        map.put("id", "db9cdc5a074246b4874683a4b1822185");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
