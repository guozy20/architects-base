package com.guozy.design.principle.carp;

public class MysqlConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Mysql数据库连接";
    }
}
