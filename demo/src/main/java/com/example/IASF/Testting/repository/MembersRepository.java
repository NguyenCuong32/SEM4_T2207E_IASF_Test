package com.example.IASF.Testting.repository;

import com.example.IASF.Testting.entity.members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<members,String> {
}
