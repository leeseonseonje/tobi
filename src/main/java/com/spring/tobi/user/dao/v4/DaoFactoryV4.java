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
}
