package com.spring.tobi.user;

import com.spring.tobi.user.dao.v4.DaoFactoryV4;
import com.spring.tobi.user.dao.v4.UserTestV4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDaoTestV4 {

    UserTestV4 userTest;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        userTest = new UserTestV4(new DaoFactoryV4().userDao());
        userTest.delete();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
        userTest.test();
    }
}
