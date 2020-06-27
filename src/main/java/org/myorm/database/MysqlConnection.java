package org.myorm.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Ted
 * @version 1.0
 * @date 2020/6/27 12:03
 */
public class MysqlConnection {

    public static Connection getLocalConnection() throws Exception {
        // 加载 Mysql 驱动
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        // 数据库连接地址
        String dbConnStr = "jdbc:mysql://localhost:3306/myorm?user=root&password=admin&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
        // 创建数据库连接
        Connection conn = DriverManager.getConnection(dbConnStr);
        return conn;
    }
}
