package com.spring.tobi.user;

import com.spring.tobi.user.dao.v4.DaoFactoryV4;
import com.spring.tobi.user.dao.v4.UserDaoV4;
import com.spring.tobi.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@SpringBootTest
public class UserDaoTestV4 {

    UserDaoV4 userDao;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV4.class);
        userDao = context.getBean("userDao", UserDaoV4.class);
        this.userDao.delete();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
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
