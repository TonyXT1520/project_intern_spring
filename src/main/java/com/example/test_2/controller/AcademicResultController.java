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
//    @Autowired
//    private AcademicResultService academicResultService;
//
//    @GetMapping("/allAcademicResults")
//    public List<AcademicResultResponse> fetchAcademicList() {
//        return academicResultService.fetchAcademicResultList();
//    }
//
//    @GetMapping("/{id}")
//    public AcademicResultResponse findAcademicResultById(@PathVariable("id") Long resultId){
//        return academicResultService.FindAcademicResultById(resultId);
//    }
//
//    @PostMapping("/addAcademicResults/{id}")
//    public AcademicResultEntity addAcademicResult(@PathVariable("id") Long studentId,@RequestBody AcademicResultEntity academicResultEntity){
//        return academicResultService.addAcademicResult(studentId, academicResultEntity);
//    }
//
//    @PutMapping("/updateAcademicResult/{id}")
//    public AcademicResultResponse updateAcademicResult(@PathVariable("id") Long resultId, @RequestBody AcademicResultRequest academicResultRequest){
//        return academicResultService.updateAcademicResult(resultId, academicResultRequest);
//    }
//
//    @DeleteMapping("/deleteAcademicResult/{id}")
//    public String deleteAcademicResult(@PathVariable("id") Long resultId){
//        academicResultService.deleteAcademicResultById(resultId);
//        return "Deleted Successfully";
//    }
}
