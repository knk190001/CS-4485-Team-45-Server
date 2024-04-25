package edu.utdallas.cs4485.team45.server.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database implements IDatabase {
    private final Connection connection;

    public Database(DatabaseConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
    }

    @Override
    public String getData() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM test");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            int id = resultSet.getInt("ID");
            String value = resultSet.getString("Value");
            return String.format("ID: %d, Value: %s", id, value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}