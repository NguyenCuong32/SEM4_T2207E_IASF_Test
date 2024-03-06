package com.example.IASF.Testting.entity;


import jakarta.persistence.*;

@Table(name = "roles")
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String user_id;
    private String role;
    public Roles(){}
    public Roles(String user_id, String role) {
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
