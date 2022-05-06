package com.spring.tobi.user;

import com.spring.tobi.user.dao.v4.DaoFactoryV4;
import com.spring.tobi.user.dao.v4.UserDaoV4;
import com.spring.tobi.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class UserDaoTestV4 {

    UserDaoV4 userDaoMaria;
    UserDaoV4 userDaoH2;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV4.class);
        userDaoMaria = context.getBean("userDaoMaria", UserDaoV4.class);
        userDaoMaria.delete();

        userDaoH2 = context.getBean("userDaoH2", UserDaoV4.class);
        userDaoH2.delete();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
        crud(userDaoMaria);
        crud(userDaoH2);
    }

    private void crud(UserDaoV4 userDao) throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("seon");
        user.setName("이선제");
        user.setPassword("seon123");

        userDao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user1 = userDao.get(user.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());

        System.out.println(user1.getId() + "조회 성공");
    }
}
