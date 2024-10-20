
package com.example;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            // Підключення до бази даних
            connection = DriverManager.getConnection("jdbc:h2:~/test138", "user", "password");

            // Налаштування Flyway
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:h2:~/test", "user", "password")
                    .load();
            // Запуск міграцій
            flyway.migrate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
