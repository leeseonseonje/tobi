package com.spring.tobi.user.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Qualifier("h2")
public class H2UserDao extends UserDao {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/tobi", "sa", "");
        return c;
    }
}
