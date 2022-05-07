package com.spring.tobi.user.dao.v5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactoryV5 {

    @Bean
    public UserDaoV5 userDaoH2DataSource() {
        return new UserDaoV5(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:h2:tcp://localhost/~/tobi", "sa", "");
    }
}
