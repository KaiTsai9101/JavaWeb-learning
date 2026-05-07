package test.chapter01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest {

    // JDBC 入门程序
    @Test
    public void testUpdate() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取数据库连接（创建连接对象/方法）
        String url = "jdbc:mysql://localhost:3306/web01";       // jdbc:mysql://主机名:端口号/数据库名，其中jdbc:mysql为协议
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 获取SQL语句执行对象（创建执行对象/方法）
        Statement statement = connection.createStatement();

        // 执行SQL语句
        // DML语句（增删改）用 excuteUpdate()；DQL语句（查询）用 excuteQuery()
        int i = statement.executeUpdate("update user set age = 25 where id = 1");
        System.out.println("SQL执行完毕影响的记录数为：" + i);

        // 释放资源
        connection.close();
        statement.close();
    }
}
