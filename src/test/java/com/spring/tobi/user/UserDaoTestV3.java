package com.spring.tobi.user;

import com.spring.tobi.user.dao.v3.ConnectionMaker;
import com.spring.tobi.user.dao.v3.MariaConnection;
import com.spring.tobi.user.dao.v3.UserDaoV3;
import com.spring.tobi.user.dao.v3.UserTestV3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDaoTestV3 {

    UserTestV3 userTest;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        ConnectionMaker maker = new MariaConnection();
        UserDaoV3 userDao = new UserDaoV3(maker);
        userTest = new UserTestV3(userDao);
        userTest.delete();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
        userTest.test();
    }
}
