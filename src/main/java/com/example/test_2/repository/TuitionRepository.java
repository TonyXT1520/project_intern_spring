package com.example.test_2.repository;

import com.example.test_2.entity.TuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepository extends JpaRepository<TuitionEntity, Long> {
}
