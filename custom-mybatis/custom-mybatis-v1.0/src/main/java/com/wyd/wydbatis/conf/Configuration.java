package com.wyd.wydbatis.conf;

import java.util.ResourceBundle;

/**
 * @ClassName :Configuration
 * @Description : 加载写了sql的文件
 * @Author : wangyudi
 * @Date : 2019/7/9 15:44
 * @Version :1.0
 */
public class Configuration {

    public static final ResourceBundle sqlMap;

    static {
        sqlMap =ResourceBundle.getBundle("BlogMapper");
    }

}
