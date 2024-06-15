package com.example.test_2.controller;

import com.example.test_2.entity.ClassEntity;
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
        return tuitionService.fetchTuitionList();
    }

    @GetMapping("/{id}")
    public TuitionResponse findTuitionById(@PathVariable("id") Integer tuitionId){
        return tuitionService.FindTuitionById(tuitionId);
    }

//    @PostMapping("/addTuition")
//    public TuitionEntity addTuition(@RequestBody TuitionEntity tuitionEntity){
//        return tuitionService.addTuition(tuitionEntity);
//    }

    @DeleteMapping("/deleteTuition/{id}")
    public String deleteTuition(@PathVariable("id") Integer tuitionId){
        tuitionService.deleteTuitionById(tuitionId);
        return "Deleted Successfully";
    }
}
