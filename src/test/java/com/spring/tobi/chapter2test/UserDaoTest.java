package com.spring.tobi.chapter2test;

import com.spring.tobi.user.dao.v5.H2FactoryV5;
import com.spring.tobi.user.dao.v5.MysqlFactoryV5;
import com.spring.tobi.user.dao.v5.UserDaoV5;
import com.spring.tobi.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
//@ContextConfiguration(classes = {H2FactoryV5.class, MysqlFactoryV5.class})
public class UserDaoTest {

    @Qualifier("userDaoMysqlDao")
    @Autowired
    UserDaoV5 mysqlUserDao;
    User userA;
    User userB;
    User userC;

    @BeforeEach
    void bean() {
        userA = new User("userA", "a", "a");
        userB = new User("userB", "b", "b");
        userC = new User("userC", "c", "c");

    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        crud(mysqlUserDao);
    }

    private void crud(UserDaoV5 userDao) throws SQLException, ClassNotFoundException {
        userDao.delete();
        int count = userDao.getCount();

        assertThat(count).isEqualTo(0);

        userDao.add(userA);
        userDao.add(userB);

        User user2 = userDao.get(userA.getId());
        assertThat(user2.getName()).isEqualTo(userA.getName());
        assertThat(user2.getPassword()).isEqualTo(userA.getPassword());

        User findUser = userDao.get(userB.getId());
        assertThat(findUser.getName()).isEqualTo(userB.getName());
        assertThat(findUser.getPassword()).isEqualTo(userB.getPassword());
    }

    @Test
    void countTest() throws SQLException, ClassNotFoundException {
        User userA = new User("userA", "a", "a");
        User userB = new User("userB", "b", "b");
        User userC = new User("userC", "c", "c");

        mysqlUserDao.delete();
        assertThat(mysqlUserDao.getCount()).isEqualTo(0);

        addCountTest(userA, 1);
        addCountTest(userB, 2);
        addCountTest(userC, 3);
    }

    private void addCountTest(User user, int count) throws SQLException, ClassNotFoundException {
        mysqlUserDao.add(user);
        assertThat(mysqlUserDao.getCount()).isEqualTo(count);
    }

    @Test
    void getUserFailed() throws SQLException, ClassNotFoundException {
        mysqlUserDao.delete();
        assertThat(mysqlUserDao.getCount()).isEqualTo(0);

        assertThatThrownBy(() -> mysqlUserDao.get("empty_id")).isInstanceOf(EmptyResultDataAccessException.class);
    }

}
