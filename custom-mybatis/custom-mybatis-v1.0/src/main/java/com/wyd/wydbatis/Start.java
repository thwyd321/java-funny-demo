package com.wyd.wydbatis;

import java.sql.*;

/**
 * @ClassName :start
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/9 11:05
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = "select bid,name,author_id from blog";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int bid = rs.getInt("bid");
                int authorId = rs.getInt("author_id");
                System.out.println(bid + "," + name + "," + authorId);
            }
            rs.close();
            statement.close();
            connection.close();



        } catch (Exception e) {

        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }


    /**
     * 取得数据库的连接
     *
     * @return 一个数据库的连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //初始化驱动类com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=UTF-8", "root", "");
            //该类就在 mysql-connector-java-5.0.8-bin.jar中,如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
