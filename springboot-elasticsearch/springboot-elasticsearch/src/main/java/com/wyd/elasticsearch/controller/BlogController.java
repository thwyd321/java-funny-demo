package com.wyd.elasticsearch.controller;

import com.wyd.elasticsearch.entity.Blog;
import com.wyd.elasticsearch.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName :SkuController
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/8/1 20:59
 * @Version :1.0
 */
@RestController
public class BlogController {


    @Autowired
    private BlogRepository blogRepository;

    @GetMapping(value = "/saveBlog")
    public Object saveBlog(){
        Blog blog = new Blog();
        blog.setBlogId("2");
        blog.setText("ssdfasdf");
        blog.setTitle("ccc");
        blog.setId(blog.getBlogId()+"_"+blog.getTitle());
        List<Blog> blogs = new ArrayList<>();
        blogs.add(blog);
        blogRepository.saveAll(blogs);//保存/更新操作

        return blog;
    }
}
