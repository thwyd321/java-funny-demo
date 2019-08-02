package com.wyd.elasticsearch.repository;

import com.wyd.elasticsearch.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName :BlogRepository
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/8/2 11:16
 * @Version :1.0
 */
public interface BlogRepository extends ElasticsearchRepository<Blog,String> {

}
