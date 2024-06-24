package com.example.test_2.controller;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.request.StudentAddRequest;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;
import com.example.test_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/allStudents")
    public List<StudentEntity> fetchStudenList(){
        return studentService.getAllStudents();
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public StudentResponse findStudentById(@PathVariable("id") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addStudent/{id}")
    public StudentResponse addStudent(@PathVariable("id") Long familyId,@RequestBody StudentAddRequest studentAddRequest){
        return studentService.addStudent(familyId, studentAddRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateStudents/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Long studentId,@RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId, studentRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{studentId}/addClass/{classId}")
    public ResponseEntity<StudentResponse> addClassToStudent(@PathVariable("studentId") Long studentId, @PathVariable("classId") Long classId){
        StudentEntity studentEntity = studentService.addClasstoStudent(studentId, classId);
        return ResponseEntity.ok(StudentResponse.mapToResponse(studentEntity));
    }
}
