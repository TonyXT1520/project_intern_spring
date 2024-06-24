package com.example.test_2.controller;


import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuition")
public class TuitionController {
    @Autowired
    private TuitionService tuitionService;

    @GetMapping("/allTuition")
    public List<TuitionResponse> fetchTuitionList() {
        return tuitionService.getAllTuition();
    }

    @GetMapping("/{id}")
    public TuitionResponse findTuitionById(@PathVariable("id") Long tuitionId){
        return tuitionService.FindTuitionById(tuitionId);
    }

    @PostMapping("/addTuition/{id}")
    public TuitionEntity addTuition(@PathVariable ("id") Long studentId, @RequestBody TuitionEntity tuitionEntity){
        return tuitionService.addTuition(studentId, tuitionEntity);
    }

    @PutMapping("/updateTuition/{id}")
    public TuitionResponse updateTuition(@PathVariable("id")Long tuitionId, @RequestBody TuitionRequest tuitionRequest){
        return tuitionService.updateTuition(tuitionRequest, tuitionId);
    }

    @DeleteMapping("/deleteTuition/{id}")
    public String deleteTuition(@PathVariable("id") Long tuitionId){
        tuitionService.deleteTuitionById(tuitionId);
        return "Deleted Successfully";
    }
}
