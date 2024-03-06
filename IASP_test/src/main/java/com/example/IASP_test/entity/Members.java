package com.example.IASP_test.entity;

import jakarta.persistence.*;

@Entity
@Table(name="members")

public class Members {
    @Id
    @Column(name="user_id")
    public String user_id;
    @Column(name="password")
    public String password;
    @Column(name="is_active")
    public Integer is_active;

    public Members() {
    }

    public Members(String user_id, String password, Integer is_active) {
        this.user_id = user_id;
        this.password = password;
        this.is_active = is_active;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }
}
