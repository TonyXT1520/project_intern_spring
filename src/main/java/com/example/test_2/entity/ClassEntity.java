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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "class_has_student",
            joinColumns = @JoinColumn(name = "class_id", foreignKey = @ForeignKey(name = "class_has_student_ibfk_2")),
            inverseJoinColumns = @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "class_has_student_ibfk_1"))
    )
    @JsonIgnore
    private List<StudentEntity> studentEntities = new ArrayList<>();
}
