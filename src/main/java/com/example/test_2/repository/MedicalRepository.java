package com.example.test_2.repository;

import com.example.test_2.entity.MedicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<MedicalEntity, Integer> {
}
