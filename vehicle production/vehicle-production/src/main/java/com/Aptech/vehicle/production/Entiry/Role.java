package com.Aptech.vehicle.production.Entiry;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {

    @Column(name = "role")
    @NotNull(message = "Role is required")
    @Size(min = 1, max = 32)
    private String role;

}
