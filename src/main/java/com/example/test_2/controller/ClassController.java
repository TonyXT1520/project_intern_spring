package com.example.test_2.controller;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.entity.ClassEntity;
import com.example.test_2.request.ClassRequest;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.ClassResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/allClass")
    public List<ClassResponse> fetchClassList() {
        return classService.fetchClassList();
    }

    @GetMapping("/{id}")
    public ClassResponse findClassById(@PathVariable("id") Integer classId){
        return classService.FindClassById(classId);
    }

//    @PostMapping("/addClass")
//    public ClassResponse addClass(@RequestBody ClassRequest classRequest){
//        return classService.addClass(classRequest);
//    }

    @DeleteMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable("id") Integer classId){
        classService.deleteClassById(classId);
        return "Deleted Successfully";
    }
}
