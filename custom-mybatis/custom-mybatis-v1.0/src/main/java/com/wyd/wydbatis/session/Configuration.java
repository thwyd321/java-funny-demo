package com.wyd.wydbatis.session;

import java.util.ResourceBundle;

/**
 * @ClassName :Configuration
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/9 15:44
 * @Version :1.0
 */
public class Configuration {

    public static final ResourceBundle sqlMap;

    static {
        sqlMap =ResourceBundle.getBundle("BlogMapper.properties");
    }

}
