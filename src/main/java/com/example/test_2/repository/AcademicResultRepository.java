package com.example.test_2.repository;

import com.example.test_2.entity.AcademicResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicResultRepository extends JpaRepository <AcademicResultEntity, Long> {
}
