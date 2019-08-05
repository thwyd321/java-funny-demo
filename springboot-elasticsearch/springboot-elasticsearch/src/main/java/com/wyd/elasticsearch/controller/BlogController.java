package com.wyd.elasticsearch.controller;

import com.wyd.elasticsearch.entity.Blog;
import com.wyd.elasticsearch.repository.BlogRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/saveBlog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object saveBlog(@RequestBody Map<String,Object> requst){

        Blog blog = new Blog();
        blog.setBlogId((String) requst.get("id"));
        blog.setTitle((String) requst.get("title"));
        blog.setText((String) requst.get("text"));
        blogRepository.save(blog);//保存/更新操作

        return blog;
    }
    @GetMapping(value = "/testBlog")
    public Object testBlog(@Param("title") String title ){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("title",title));

        Page<Blog> search = blogRepository.search(queryBuilder.build());

        return search;
    }



}
