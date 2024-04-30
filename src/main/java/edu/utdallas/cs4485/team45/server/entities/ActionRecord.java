package edu.utdallas.cs4485.team45.server.entities;

public record ActionRecord(
    String username,
    String target,
    Action action,
    Card card
)  { }
