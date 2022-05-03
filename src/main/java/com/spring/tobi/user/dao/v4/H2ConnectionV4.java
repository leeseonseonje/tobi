package com.spring.tobi.user.dao.v4;

import com.spring.tobi.user.dao.v3.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionV4 implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/tobi", "sa", "");
        return c;
    }
}
