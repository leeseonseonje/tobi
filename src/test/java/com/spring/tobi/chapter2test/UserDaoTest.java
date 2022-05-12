package com.spring.tobi.chapter2test;

import com.spring.tobi.user.dao.v5.H2FactoryV5;
import com.spring.tobi.user.dao.v5.MariaFactoryV5;
import com.spring.tobi.user.dao.v5.UserDaoV5;
import com.spring.tobi.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class UserDaoTest {

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(H2FactoryV5.class, MariaFactoryV5.class);

        UserDaoV5 h2UserDao = applicationContext.getBean("userDaoH2DataSource", UserDaoV5.class);

        UserDaoV5 mariaUserDao = applicationContext.getBean("userDaoMariaDataSource", UserDaoV5.class);

        crud(mariaUserDao);
        crud(h2UserDao);
    }

    private void crud(UserDaoV5 userDao) throws SQLException, ClassNotFoundException {
        userDao.delete();
        int count = userDao.getCount();

        assertThat(count).isEqualTo(0);

        User user = new User();
        user.setId("yeongdonge");
        user.setName("김동영");
        user.setPassword("cute");

        userDao.add(user);

        User user2 = userDao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }
}
