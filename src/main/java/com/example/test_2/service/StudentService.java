package com.example.test_2.service;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse addStudent(StudentRequest studentRequest);

    List<StudentResponse> fetchStudentList();

    StudentResponse findStudentById(Integer studentId);

    StudentResponse updateStudent(StudentRequest studentRequest, Integer studentId);

    void deleteStudentById(Integer studentId);
}
