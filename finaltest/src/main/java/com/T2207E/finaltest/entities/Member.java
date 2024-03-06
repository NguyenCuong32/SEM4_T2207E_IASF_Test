package com.T2207E.finaltest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String UserId;

    @Column(name = "password", nullable = false, length = 68)
    @NotBlank(message = "*passwrod is required")
    @Size(max = 68, message = "password  cannot exceed 68 characters")
    private String password;

    @Column(name = "is_active", nullable = false)
    @NotBlank(message = "*is active is required")
    private String isActive;

}
