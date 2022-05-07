package com.spring.tobi.user;

import com.spring.tobi.user.dao.v4.CountingDaoFactoryV4;
import com.spring.tobi.user.dao.v4.DaoFactoryV4;
import com.spring.tobi.user.dao.v4.UserDaoV4;
import com.spring.tobi.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class UserDaoTestV4 {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV4.class);
    ApplicationContext countingContext = new AnnotationConfigApplicationContext(CountingDaoFactoryV4.class);

    @Test
    void mariaDbTest() throws SQLException, ClassNotFoundException {
        UserDaoV4 userDaoMaria = context.getBean("userDaoMaria", UserDaoV4.class);
        userDaoMaria.delete();
        crud(userDaoMaria);
    }

    @Test
    void h2DbTest() throws SQLException, ClassNotFoundException {
        UserDaoV4 userDaoH2 = countingContext.getBean("userDaoH2", UserDaoV4.class);
        userDaoH2.delete();
        crud(userDaoH2);
    }

    private void crud(UserDaoV4 userDao) throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("seon");
        user.setName("이선제");
        user.setPassword("seon123");

        userDao.add(user);

        User user1 = userDao.get(user.getId());

        assertThat(user1.getId()).isEqualTo(user.getId());
        assertThat(user1.getName()).isEqualTo(user.getName());
    }
}
