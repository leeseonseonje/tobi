package com.spring.tobi.chapter2test;

import com.spring.tobi.user.dao.v5.H2FactoryV5;
import com.spring.tobi.user.dao.v5.MariaFactoryV5;
import com.spring.tobi.user.dao.v5.UserDaoV5;
import com.spring.tobi.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class UserDaoTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(H2FactoryV5.class, MariaFactoryV5.class);

    UserDaoV5 h2UserDao;

    UserDaoV5 mariaUserDao;

    @BeforeEach
    void bean() {
        h2UserDao = applicationContext.getBean("userDaoH2DataSource", UserDaoV5.class);
        mariaUserDao = applicationContext.getBean("userDaoMariaDataSource", UserDaoV5.class);
    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
//        crud(mariaUserDao);
        crud(h2UserDao);
    }

    private void crud(UserDaoV5 userDao) throws SQLException, ClassNotFoundException {
        userDao.delete();
        int count = userDao.getCount();

        assertThat(count).isEqualTo(0);

        User user = new User("김동영", "cute", "sexy");

        userDao.add(user);

        User user2 = userDao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void countTest() throws SQLException, ClassNotFoundException {
        User userA = new User("userA", "a", "a");
        User userB = new User("userB", "b", "b");
        User userC = new User("userC", "c", "c");

        h2UserDao.delete();
        assertThat(count()).isEqualTo(0);

        addCountTest(userA, 1);
        addCountTest(userB, 2);
        addCountTest(userC, 3);
    }

    private int count() throws SQLException {
        return h2UserDao.getCount();
    }

    private void addCountTest(User user, int count) throws SQLException, ClassNotFoundException {
        h2UserDao.add(user);
        assertThat(count).isEqualTo(count);
    }
}
