package com.spring.tobi.user.dao.v1;

import com.spring.tobi.user.dao.v1.UserDaoV1;
import com.spring.tobi.user.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserTestV1 {

    private final UserDaoV1 userDao;

    public UserTestV1(UserDaoV1 userDao) {
        this.userDao = userDao;
    }

    public void test() throws SQLException, ClassNotFoundException {

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

    public void delete() throws SQLException, ClassNotFoundException {
        userDao.delete();
    }

}
