package org.myorm.step030;

import org.myorm.database.MysqlConnection;
import org.myorm.step030.entity.UserEntity;
import org.myorm.step030.entity.XxxEntity_Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 主应用程序类
 */
public class App030 {
    /**
     * 应用程序主函数
     *
     * @param argvArray 参数数组
     * @throws Exception
     */
    static public void main(String[] argvArray) throws Exception {
        (new org.myorm.step030.App030()).start();
    }

    /**
     * 测试开始
     */
    private void start() throws Exception {
        //获取本地mysql连接
        Connection conn = MysqlConnection.getLocalConnection();
        // 简历陈述对象
        Statement stmt = conn.createStatement();

        // 创建 SQL 查询
        String sql = "select * from t_user limit 2000000";

        // 执行查询
        ResultSet rs = stmt.executeQuery(sql);
        // 创建助手类
        XxxEntity_Helper helper = new XxxEntity_Helper();

        // 获取开始时间
        long t0 = System.currentTimeMillis();

        while (rs.next()) {
            // 创建新的实体对象
            UserEntity ue = helper.create(UserEntity.class, rs);
        }

        // 获取结束时间
        long t1 = System.currentTimeMillis();

        // 关闭数据库连接
        stmt.close();
        conn.close();

        // 打印实例化花费时间
        System.out.println("实例化花费时间 = " + (t1 - t0) + "ms");
        // 注意: 到这里运行时间翻倍了!
        // 利用反射确实可以获得良好的通用性,
        // 但是却损失了性能...
    }
}
