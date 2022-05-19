package com.spring.tobi.user.dao.v5;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MysqlFactoryV5 {

    @Bean
    public UserDaoV5 userDaoMysqlDao() {
        return new UserDaoV5(mysql());
    }

    @Bean
    public DataSource mysql() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/tobi");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMaximumPoolSize(10);
        return dataSource;
    }
}
