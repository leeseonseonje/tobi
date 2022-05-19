package com.spring.tobi.user;

import com.spring.tobi.user.dao.v5.H2FactoryV5;
import com.spring.tobi.user.dao.v5.MysqlFactoryV5;
import com.spring.tobi.user.dao.v5.UserDaoV5;
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
public class UserDaoTestV5 {

    ApplicationContext context = new AnnotationConfigApplicationContext(H2FactoryV5.class, MysqlFactoryV5.class);

    @Test
    void h2DbTest() throws SQLException, ClassNotFoundException {
        UserDaoV5 userDaoH2 = context.getBean("userDaoH2DataSource", UserDaoV5.class);
        UserDaoV5 userDaoMaria = context.getBean("userDaoMysqlDao", UserDaoV5.class);
        userDaoH2.delete();
        crud(userDaoMaria);
        crud(userDaoH2);
    }

    private void crud(UserDaoV5 userDao) throws SQLException, ClassNotFoundException {
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
