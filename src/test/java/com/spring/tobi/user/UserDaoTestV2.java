package com.spring.tobi.user;

import com.spring.tobi.user.dao.v2.UserTestV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class UserDaoTestV2 {

    @Autowired
    UserTestV2 userTest;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        userTest.delete();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
        userTest.test();
    }
}
