package com.example.IASF.Testting.entity;

import jakarta.persistence.*;

@Table(name = "members")
@Entity
public class members {
    @Id
   private String user_id;
   private String password ;
   private boolean is_active;
    public members(){}
    public members(String user_id, String password, boolean is_active) {
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

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
