package com.example.test_2.repository;

import com.example.test_2.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<FamilyEntity, Integer> {

}
