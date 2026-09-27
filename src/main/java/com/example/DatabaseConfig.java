package com.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection getConnection() throws SQLException {

        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String dbName = System.getenv("DB_NAME");

        if (user == null || password == null || host == null || port == null || dbName == null) {
            throw new RuntimeException("Missing environment variables for DB connection");
        }

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setUser(user);
        datasource.setPassword(password);
        datasource.setUrl(url);

        return datasource.getConnection();
    }
}
