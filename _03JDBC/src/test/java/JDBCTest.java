import org.example.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    @Test
    public void testUpdate() throws Exception{
        //1 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2 获取连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "0704";
        DriverManager.getConnection(url,username,password);
        Connection connection = DriverManager.getConnection(url,username,password);

        //3 获取sql语句执行对象
       Statement statement = connection.createStatement();

        //4 执行sql语句
        int  i = statement.executeUpdate("update user set age = 25 where id =1");//DML
        System.out.println("SQL执行完毕影响的记录数为：" + i);

        //5 释放对象
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect(){
        String url = "jdbc:mysql://localhost:3306/web01";
        String dbUsername = "root";
        String password = "0704";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;//封装查询结果

        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 获取连接
            connection = DriverManager.getConnection(url, dbUsername, password);

            // 3. 定义SQL语句
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";//预编译 SQL 性能高，安全

            // 4. 获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);

            // 5. 设置参数
            preparedStatement.setString(1, "daqiao");
            preparedStatement.setString(2, "123456");

            // 6. 执行查询
            resultSet = preparedStatement.executeQuery();

            // 7. 处理结果集
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                // 创建User对象并封装数据
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));

                userList.add(user);
            }

            // 输出查询结果
            if (userList.isEmpty()) {
                System.out.println("未找到匹配的用户");
            } else {
                System.out.println("查询到 " + userList.size() + " 个用户:");
                for (User user : userList) {
                    System.out.println(user);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("找不到MySQL驱动类");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库操作异常");
            e.printStackTrace();
        } finally {//正常或者抛异常，都执行
            // 8. 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
