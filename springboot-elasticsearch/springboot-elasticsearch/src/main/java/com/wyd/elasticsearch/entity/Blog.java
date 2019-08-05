package com.wyd.elasticsearch.entity;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @ClassName :Blog
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/8/2 11:14
 * @Version :1.0
 */
@Data
@Document(indexName = "website")
public class Blog {

    @Id
    private String blogId;
    @Field(type = FieldType.Text,analyzer = "analysis-ik")
    private String title;
    private String text;
    private String date;

}
