package com.uni.finaltest.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Members {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private String userId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "is_active")
    private byte isActive;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return isActive == members.isActive && Objects.equals(userId, members.userId) && Objects.equals(password, members.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, isActive);
    }
}
