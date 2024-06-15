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
    @Autowired
    private MedicalService medicalService;

    @GetMapping("/allMedical")
    public List<MedicalResponse> fetchMedicalList() {
        return medicalService.fetchMedicalList();
    }

    @GetMapping("/{id}")
    public MedicalResponse findMedicalById(@PathVariable("id") Integer medicalId){
        return medicalService.FindMedicalById(medicalId);
    }

//    @PostMapping("/addMedical")
//    public MedicalResponse addMedical(@RequestBody MedicalRequest medicalRequest){
//        return medicalService.addMedical(medicalRequest);
//    }

    @DeleteMapping("/deleteMedical/{id}")
    public String deleteMedical(@PathVariable("id") Integer medicalId){
        medicalService.deleteMedicalById(medicalId);
        return "Deleted Successfully";
    }
}
