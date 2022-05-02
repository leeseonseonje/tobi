package com.spring.tobi.user.dao.v1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Primary
public class MariaUserDao extends UserDaoV1 {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/tobi", "root", "mariadb");
        return c;
    }
}
