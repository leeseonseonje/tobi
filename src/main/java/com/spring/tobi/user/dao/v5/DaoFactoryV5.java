package com.spring.tobi.user.dao.v5;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactoryV5 {

    @Bean
    public UserDaoV5 userDaoH2DataSource() {
        return new UserDaoV5(h2());
    }

    @Bean
    public DataSource h2() {
        return new DriverManagerDataSource("jdbc:h2:tcp://localhost/~/tobi", "sa", "");
    }

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
        return dataSource;
    }
}
