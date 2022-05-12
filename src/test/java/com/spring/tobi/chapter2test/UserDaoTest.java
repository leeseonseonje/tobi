package com.spring.tobi.chapter2test;

import com.spring.tobi.user.dao.v5.DaoFactoryV5;
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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactoryV5.class);

        UserDaoV5 userDao = applicationContext.getBean("userDaoH2DataSource", UserDaoV5.class);

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
