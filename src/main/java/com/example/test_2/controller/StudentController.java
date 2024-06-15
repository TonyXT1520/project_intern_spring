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
    public List<StudentResponse> fetchStudenList(){
        return studentService.fetchStudentList();
    }

    @GetMapping("/{id}")
    public StudentResponse findStudentById(@PathVariable("id") Integer studentId){
        return studentService.findStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest){

        return studentService.addStudent(studentRequest);
    }

    @PutMapping("/updateStudents/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable("id") Integer studentId){
        return studentService.updateStudent(studentRequest, studentId);
    }

    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable("id") Integer studentId){
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }
}
