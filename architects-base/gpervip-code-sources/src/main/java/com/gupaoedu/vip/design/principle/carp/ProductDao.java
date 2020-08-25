package com.gupaoedu.vip.design.principle.carp;

public class ProductDao {
    private DBConnection connection;

    public DBConnection getConnection() {
        return connection;
    }

    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }

    public void addProduct(){
        String conn = connection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
