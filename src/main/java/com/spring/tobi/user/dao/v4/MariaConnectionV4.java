package com.spring.tobi.user.dao.v4;

import com.spring.tobi.user.dao.v3.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaConnectionV4 implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/tobi", "root", "mariadb");
        return c;
    }
}
