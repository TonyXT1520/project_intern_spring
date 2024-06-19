package com.example.test_2.controller;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.MedicalResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.ClassService;
import com.example.test_2.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalController {
//    @Autowired
//    private MedicalService medicalService;
//
//    @GetMapping("/allMedical")
//    public List<MedicalResponse> fetchMedicalList() {
//        return medicalService.fetchMedicalList();
//    }
//
//    @GetMapping("/{id}")
//    public MedicalResponse findMedicalById(@PathVariable("id") Long medicalId){
//        return medicalService.FindMedicalById(medicalId);
//    }
//
//    @PostMapping("/addMedical/{id}")
//    public MedicalEntity addMedical(@PathVariable("id") Long studentId,@RequestBody MedicalEntity medicalEntity){
//        return medicalService.addMedical(studentId, medicalEntity);
//    }
//
//    @PutMapping("/updateMedical/{id}")
//    public MedicalResponse updateMedical(@PathVariable("id") Long medicalId,@RequestBody MedicalRequest medicalRequest){
//        return medicalService.updateMedical(medicalId, medicalRequest);
//    }
//
//    @DeleteMapping("/deleteMedical/{id}")
//    public String deleteMedical(@PathVariable("id") Long medicalId){
//        medicalService.deleteMedicalById(medicalId);
//        return "Deleted Successfully";
//    }
}
