package com.uni.finaltest.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Basic
    @Column(name = "user_id")
    private String userId;
    @Basic
    @Column(name = "role")
    private String role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(userId, roles.userId) && Objects.equals(role, roles.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, role);
    }
}
