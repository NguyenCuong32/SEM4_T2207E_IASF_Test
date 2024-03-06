package com.example.IASF.Testting.repository;

import com.example.IASF.Testting.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,String> {
}
