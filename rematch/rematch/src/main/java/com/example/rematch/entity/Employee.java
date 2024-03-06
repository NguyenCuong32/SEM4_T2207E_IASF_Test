package com.example.rematch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
    @Table(name = "employee")
    public  class Employee {
    @Id
    @Column(name="employeeid")
    public String employeeId;
    @Column(name = "employeename")
    @NotNull(message = " name is require")
    @Size(message = "First name is required")
    public String employeeName;

    @Column(name = "birthday")
    @NotNull(message = "birthday is required")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public String birthday;

    @Column(name = "phonenumber")
    @NotNull(message = "phoneNumber is required")
    public String phoneNumber;
    @Column(name = "email")
    @NotNull(message = "Email is required")
    @Size(min = 1,message = "Email is required")
    @Email(message = "Email is not format")
    public String email;
    public Employee(){

    }

    public Employee(String employeeId, String employeeName, String birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

