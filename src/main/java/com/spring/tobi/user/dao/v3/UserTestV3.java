package com.spring.tobi.user.dao.v3;

import com.spring.tobi.user.dao.v2.UserDaoV2;
import com.spring.tobi.user.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

public class UserTestV3 {

    private UserDaoV3 userDao;

    public UserTestV3(UserDaoV3 userDao) {
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
