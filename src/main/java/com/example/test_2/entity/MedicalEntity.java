package com.example.test_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "medical")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalEntity {
    @Id
    @Column(name = "medical_id")
    private Long medicalId;

    @Column(name = "health_status")
    private String healthStatus;

    @Column(name = "vaccination_history")
    private String vaccinationHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "medical_ibfk_1"))
    @JsonIgnore
    private StudentEntity studentEntity;

}
