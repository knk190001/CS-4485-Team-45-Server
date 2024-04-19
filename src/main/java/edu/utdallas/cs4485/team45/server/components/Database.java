package edu.utdallas.cs4485.team45.server.components;

import java.sql.Connection;

public class Database implements IDatabase {
    private final Connection connection;

    public Database(DatabaseConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
    }

    @Override
    public String getData() {
        return null;
    }
}
