package edu.utdallas.cs4485.team45.server.components;

import org.springframework.stereotype.Component;

import java.util.Optional;

public class Environment {
    public final String DB_HOST_NAME = System.getenv("DB_HOST_NAME");
    public final String DB_PORT = System.getenv("DB_PORT");
    public final String DB_USERNAME = System.getenv("DB_USERNAME");

    public boolean isValid() {
        return DB_HOST_NAME != null && DB_PORT != null && DB_USERNAME != null;
    }
}
