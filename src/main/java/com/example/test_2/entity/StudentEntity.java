package com.example.test_2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private String dayofBirth;

    @Column(name = "gender")
    private String address;

    @Column(name = "address")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEntity", fetch = FetchType.LAZY)
    private List<TuitionEntity> tuitionEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEntity", fetch = FetchType.LAZY)
    private List<MedicalEntity> medicalEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEntity", fetch = FetchType.LAZY)
    private List<AcademicResultEntity> academicResultEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", foreignKey = @ForeignKey(name = "student_ibfk_1"))
    @JsonIgnore
    private FamilyEntity familyEntity;

    @ManyToMany(mappedBy = "studentEntities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassEntity> classEntities = new ArrayList<>();

}
