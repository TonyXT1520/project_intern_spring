package com.example.test_2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "family")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyEntity {
    @Id
    @Column(name = "family_id")
    private int familyId;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "father_phone")
    private String fatherPhone;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "mother_phone")
    private String motherPhone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyEntity", fetch = FetchType.LAZY)
    private List<StudentEntity> studentEntities;
}
