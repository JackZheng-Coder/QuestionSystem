package com.dao;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
//连接数据库基本配置
public interface JdbcConfig {
    String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/questions";
    String USERNAME = "root";
    String PASSWORD = "123";
}
