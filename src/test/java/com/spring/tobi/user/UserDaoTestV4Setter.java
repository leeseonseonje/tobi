package com.spring.tobi.user;

import com.spring.tobi.user.dao.v4_setter.DaoFactoryV4Setter;
import com.spring.tobi.user.dao.v4_setter.UserDaoV4Setter;
import com.spring.tobi.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class UserDaoTestV4Setter {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV4Setter.class);

    @Test
    void h2DbTest() throws SQLException, ClassNotFoundException {
        UserDaoV4Setter userDaoH2 = context.getBean("userDaoH2SetterDI", UserDaoV4Setter.class);
        userDaoH2.delete();
        crud(userDaoH2);
    }

    private void crud(UserDaoV4Setter userDao) throws SQLException, ClassNotFoundException {
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
