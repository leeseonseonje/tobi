package com.spring.tobi.user.dao.v4;

import com.spring.tobi.user.domain.User;

import java.sql.SQLException;

public class UserTestV4 {

    private UserDaoV4 userDao;

    public UserTestV4(UserDaoV4 userDao) {
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
