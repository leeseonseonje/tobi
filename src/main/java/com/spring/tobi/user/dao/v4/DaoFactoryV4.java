package com.spring.tobi.user.dao.v4;

import com.spring.tobi.user.dao.v3.ConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactoryV4 {

    @Bean
    public UserDaoV4 userDaoMaria() {
        return new UserDaoV4(connectionMaria());
    }

    @Bean
    public ConnectionMaker connectionMaria() {
        return new MariaConnectionV4();
    }

    @Bean
    public UserDaoV4 userDaoH2() {
        return new UserDaoV4((connectionH2()));
    }

    @Bean
    public ConnectionMaker connectionH2() {
        return new H2ConnectionV4();
    }
}
