package com.wyd.elasticsearch.controller;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :SkuController
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/8/1 20:59
 * @Version :1.0
 */
@RestController
public class SkuController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping(value = "/createSku", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object createSku(){
        /*boolean index = elasticsearchTemplate.createIndex(.class);
        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId("1");
        elasticsearchTemplate.index(indexQuery);
        return index;*/
        return null;
    }

}
