package com.spring.tobi.user.dao.v5;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MariaFactoryV5 {

    @Bean
    public UserDaoV5 userDaoMariaDataSource() {
        return new UserDaoV5(maria());
    }

    @Bean
    public DataSource maria() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/tobi");
        dataSource.setUsername("root");
        dataSource.setPassword("mariadb");
        dataSource.setMaximumPoolSize(10);
        return dataSource;
    }
}
