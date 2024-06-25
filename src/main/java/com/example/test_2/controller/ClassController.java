package com.example.test_2.controller;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.request.ClassRequest;
import com.example.test_2.response.ClassResponse;
import com.example.test_2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassResponse> fetchClassList() {
        return classService.fetchClassList();
    }

    @GetMapping("/{id}")
    public ClassResponse findClassById(@PathVariable("id") Long classId){
        return classService.FindClassById(classId);
    }

    @PostMapping("/{id}")
    public ClassEntity addClass(@PathVariable("id") Long studentId,@RequestBody ClassEntity classEntity){
        return classService.addClass(studentId, classEntity);
    }

    @PutMapping("/{id}")
    public ClassResponse updateClass(@PathVariable("id") Long classId, @RequestBody ClassRequest classRequest){
        return classService.updateClass(classId, classRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable("id") Long classId){
        classService.deleteClassById(classId);
        return "Deleted Successfully";
    }
}
