package com.example.IASP_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")

public class roles {
    @Column(name="user_id")
    public String user_id;
    @Column(name="role")
    public String role;

    public roles() {
    }

    public roles(String user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
