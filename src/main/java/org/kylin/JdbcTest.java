/**
 * BrandBigData.com Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.kylin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author HaoBin
 * @version $Id: JdbcTest.java, v0.1 2018/3/28 9:26 HaoBin
 */
public class JdbcTest {

    public static void main(String[] args) throws Exception{
        Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();

        Properties info = new Properties();
        info.put("user", "admin");
        info.put("password", "KYLIN");
        Connection conn = driver.connect("jdbc:kylin://finance-06:7070/bbd_plutus_rating", info);
        Statement state = conn.createStatement();
        ResultSet resultSet = state.executeQuery("SELECT * from decision_record");
        String i = "12";
    }

}