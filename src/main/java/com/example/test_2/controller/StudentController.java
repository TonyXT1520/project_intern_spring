package com.example.test_2.controller;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;
import com.example.test_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allStudents")
    public List<StudentEntity> fetchStudenList(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse findStudentById(@PathVariable("id") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @PostMapping("/addStudent/{id}")
    public StudentResponse addStudent(@PathVariable("id") Long familyId,@RequestBody StudentEntity studentEntity){
        return studentService.addStudent(familyId, studentEntity);
    }

    @PutMapping("/updateStudents/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable("id") Long studentId){
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }
}
