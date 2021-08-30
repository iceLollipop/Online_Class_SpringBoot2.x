package net.onlineclass;

import java.sql.*;

public class JdbcApplication {
    public static void main(String args[]) throws Exception {
        //加载JDBC驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //数据库环境和账户
        String url = "jdbc:mysql://127.0.0.1:3306/online_class?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        //获取连接对象，并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);

        //获取语句对象
        Statement statement = connection.createStatement();

        //获取结果集
        ResultSet resultSet = statement.executeQuery("select * from video");

        while (resultSet.next()){
            System.out.println("视频标题:"+resultSet.getString("title"));
        }

        statement.close();
    }
}
