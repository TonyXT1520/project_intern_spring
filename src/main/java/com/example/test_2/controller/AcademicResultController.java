package com.example.test_2.controller;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.request.AcademicResultRequest;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.AcademicResultResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.AcademicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AcademicResult")
public class AcademicResultController {
    @Autowired
    private AcademicResultService academicResultService;

    @GetMapping("/allAcademicResults")
    public List<AcademicResultResponse> fetchAcademicList() {
        return academicResultService.fetchAcademicResultList();
    }

    @GetMapping("/{id}")
    public AcademicResultResponse findAcademicResultById(@PathVariable("id") Integer resultId){
        return academicResultService.FindAcademicResultById(resultId);
    }

//    @PostMapping("/addTuition")
//    public AcademicResultResponse addAcademicResult(@RequestBody AcademicResultRequest academicResultRequest){
//        return academicResultService.addAcademicResult(academicResultRequest);
//    }

    @DeleteMapping("/deleteAcademicResult/{id}")
    public String deleteAcademicResult(@PathVariable("id") Integer resultId){
        academicResultService.deleteAcademicResultById(resultId);
        return "Deleted Successfully";
    }
}
