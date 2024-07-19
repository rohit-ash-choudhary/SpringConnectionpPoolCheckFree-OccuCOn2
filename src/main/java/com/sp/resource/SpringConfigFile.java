package com.sp.resource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SpringConfigFile {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
        config.setUsername("root");
        config.setPassword("Rooh@#2001");
        config.setMaximumPoolSize(5);

        // Create a new HikariDataSource with the specified config
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        // Configure JdbcTemplate with the DataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}
