package edu.utdallas.cs4485.team45.server.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;


public class DatabaseConnectionManager {
    private final Connection connection;

    public DatabaseConnectionManager(Environment environment) throws SQLException {
        assert environment.isValid();
        connection = createConnection(environment);
    }

    public Connection getConnection() {
        return Objects.requireNonNull(connection);
    }

    private Connection createConnection(Environment environment) throws SQLException {
        String JDBC_URL = "jdbc:mysql:aws://" + environment.DB_HOST_NAME + ":" + environment.DB_PORT + "/main";
        Properties dbProperties = new Properties();
        dbProperties.setProperty("useAwsIam", "true");
        dbProperties.setProperty("user", environment.DB_USERNAME);
        return DriverManager.getConnection(JDBC_URL, dbProperties);
    }
}
