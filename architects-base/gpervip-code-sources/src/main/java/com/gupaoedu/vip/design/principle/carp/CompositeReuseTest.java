package com.gupaoedu.vip.design.principle.carp;

public class CompositeReuseTest {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setConnection(new MysqlConnection());
        productDao.addProduct();

        productDao.setConnection(new OracleConnection());
        productDao.addProduct();
    }
}
