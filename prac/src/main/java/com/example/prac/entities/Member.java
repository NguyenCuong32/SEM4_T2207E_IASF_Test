package com.example.prac.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member implements Serializable {
    @Id
    @Column(name = "user_id", length = 32, nullable = false)
    private String userId;

    @Column(name = "password", length = 68, nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    // Relationship with Role entity (unidirectional)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
    private List<Role> roles;
}