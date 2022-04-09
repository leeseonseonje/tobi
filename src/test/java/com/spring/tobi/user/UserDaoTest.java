package com.spring.tobi.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class UserDaoTest {

    @Autowired UserTest userTest;

    @Test
    void test() throws SQLException, ClassNotFoundException {
        userTest.test();
    }
}
