package com.spring.tobi.user.dao.v4;

import com.spring.tobi.user.dao.v3.ConnectionMaker;

public class DaoFactoryV4 {

    public UserDaoV4 userDao() {
        return new UserDaoV4(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new MariaConnectionV4();
    }
}
