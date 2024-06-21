package com.example.test_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {
    @Id
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "grade_level")
    private String GradeLevel;

    @ManyToMany(mappedBy = "classEntities" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @JsonIgnore
    private List<StudentEntity> studentEntities =new ArrayList<>();
}
