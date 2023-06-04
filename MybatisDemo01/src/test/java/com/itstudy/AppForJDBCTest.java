package com.itstudy;

import com.itstudy.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppForJDBCTest {

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        //1, 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2, 获取连接对象
        String url = "jdbc:mysql://localhost:3306/sql_store";
        String username = "mybatis";
        String password ="mybatis";
        Connection connection = DriverManager.getConnection(url, username,password);

        //3, 获取执行SQL的对象Statement, 执行SQL, 返回结果
        String sql = "select * from customers limit 10";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        //4, 封装结果数据
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            int customer_id = resultSet.getInt("customer_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String birth_date = resultSet.getString("birth_date");
            String phone = resultSet.getString("phone");

            User user = new User(customer_id, first_name, last_name, birth_date, phone);
            userList.add(user);
        }
        userList.stream().forEach(System.out::println);

        //5, 释放资源
        statement.close();
        resultSet.close();




    }
}
