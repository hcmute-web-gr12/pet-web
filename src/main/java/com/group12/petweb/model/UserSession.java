package com.group12.petweb.model;

import java.util.UUID;

public class UserSession {
    private UUID id;
    public UserSession() {
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                '}';
    }
}
