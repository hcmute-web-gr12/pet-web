package com.group12.petweb.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity
@Table(name = "USERS")
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    public UUID getId() { return id; }

    @Column(name = "NAME")
    public String getName() { return name; }

    @NotNull
    @Column(name = "EMAIL", unique = true, nullable = false)
    public String getEmail() { return email; }

    @Column(name = "PASSWORD", columnDefinition = "varchar(72)")
    public String getPassword() {
        return password;
    }

    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) {
        this.password = password;
    }
}
