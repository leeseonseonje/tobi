package com.spring.tobi.user.dao.v4_setter;

import com.spring.tobi.user.dao.v4.H2ConnectionV4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoFactoryV4Setter {

    @Bean
    public UserDaoV4Setter userDaoH2SetterDI() {
        UserDaoV4Setter userDao = new UserDaoV4Setter();
        userDao.setConnectionMaker(new H2ConnectionV4());
        return userDao;
    }
}
