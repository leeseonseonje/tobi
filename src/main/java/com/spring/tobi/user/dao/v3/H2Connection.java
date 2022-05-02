package com.spring.tobi.user.dao.v3;

import com.spring.tobi.user.dao.v1.UserDaoV1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Qualifier("h2")
public class H2Connection implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/tobi", "sa", "");
        return c;
    }
}
