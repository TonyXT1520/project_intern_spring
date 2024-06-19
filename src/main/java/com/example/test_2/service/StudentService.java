package com.example.test_2.service;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse addStudent(Long familyId, StudentEntity studentEntity);

    List<StudentEntity> getAllStudents();

    StudentResponse findStudentById(Long studentId);

    StudentResponse updateStudent( Long studentId, StudentRequest studentRequest);

    void deleteStudentById(Long studentId);
}
