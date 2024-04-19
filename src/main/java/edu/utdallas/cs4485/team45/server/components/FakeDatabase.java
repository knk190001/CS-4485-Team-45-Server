package edu.utdallas.cs4485.team45.server.components;

public class FakeDatabase implements IDatabase {
    @Override
    public String getData() {
        return "FakeData";
    }
}
